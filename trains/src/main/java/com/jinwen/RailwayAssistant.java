package com.jinwen;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/12
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayAssistant{
    private RailwayMap railwayMap = new RailwayMap();

    public RailwayAssistant(String map) {
        railwayMap.mapLoader(map);
    }

    public int getStopsLessPathNum(String start, String finish, int max) {
        int number = 0;
        ArrayList<ArrayList<String>> list = railwayMap.getPath(start, finish);
        if (list.size() > 0) {
            for (ArrayList<String> path : list) {
                if (path.size() - 1 < max) {
                    number++;
                }
            }
        }
        return number;
    }

    public int getExactStopNumber(String start, String finish, int max) {
        int number = 0;
        ArrayList<ArrayList<String>> list1 = railwayMap.getPath(start, finish);
        RailwayMap secondMap = new RailwayMap(railwayMap.getOriMap());
        ArrayList<ArrayList<String>> list2 = secondMap.getPath(finish, finish);
        if (list1.size() > 0) {
            for (ArrayList<String> path : list1) {
                if (path.size() - 1 == max) {
                    number++;
                } else if (list2.size() > 0) {
                    for (ArrayList<String> var : list2) {
                        if ((var.size() + path.size() - 2) == max) {
                            number++;
                        }
                    }
                }
            }
        }
        return number;
    }

    public int getShortestPath(String start, String finish) throws Exception {
        int shortestDistance = 999;
        int distance;
        ArrayList<ArrayList<String>> list = railwayMap.getPath(start, finish);
        if (list.size() > 0) {
            for (ArrayList<String> path : list) {
                String railway = "";
                for (String str : path) {
                    railway += str;
                }
                distance = railwayMap.getPathDistance(railway);
                if (shortestDistance > distance) {
                    shortestDistance = distance;
                }
            }
            return shortestDistance;
        }
        return -1;
    }

    public int getLessDistancePathsNum(String start, String finish, int length) throws Exception {
        ArrayList<String> resultSet = new ArrayList<String>();
        ArrayList<ArrayList<String>> result = railwayMap.getPath(start, finish);
        ArrayList<String> pathSet = new ArrayList<String>();
        if (result.size() > 0) {
            for (ArrayList<String> element : result) {
                String railway = "";
                for (String str : element) {
                    railway += str;
                }
                if (railwayMap.getPathDistance(railway) < length) {
                    pathSet.add(railway);
                    resultSet.add(railway);
                }
            }
            ArrayList<String> suffix = getSuffix(pathSet);
            for (String prefix : pathSet) {
                findOtherRoads(resultSet, prefix, suffix, length);
            }
        }
        return resultSet.size();
    }

    private void findOtherRoads(ArrayList<String> resultSet, String prefix, ArrayList<String> suffix, int distance) throws Exception {
        if (railwayMap.getPathDistance(prefix) >= distance) {
            return;
        }
        for (String str : suffix) {
            if (railwayMap.getPathDistance(prefix + str) < distance) {
                resultSet.add(prefix + str);
                findOtherRoads(resultSet, prefix + str, suffix, distance);
            }
        }
    }

    private ArrayList<String> getSuffix(ArrayList<String> pathSet) {
        ArrayList<String> suffix = new ArrayList<String>();
        for (String str : pathSet) {
            suffix.add(str.substring(1));
        }
        return suffix;
    }
}
