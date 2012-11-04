
package com.jinwen;
import java.util.*;


/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayMap {
    private Map<String, Map<String, String>> railwayMap = new HashMap<String, Map<String, String>>();
    private PathResolver pathResolver = new PathResolver();
    private String oriMap = "";

    public String getOriMap() {
        return oriMap;
    }

    RailwayMap() {
    }

    RailwayMap(String map) {
        this.mapLoader(map);
    }

    private void setPathInfo(String path) {
        String srcCity = String.valueOf(path.charAt(0)),
                dstCity = String.valueOf(path.charAt(1)),
                distance = String.valueOf(path.charAt(2));
        if (railwayMap.containsKey(srcCity)) {
            Map<String, String> otherCity = railwayMap.get(srcCity);
            otherCity.put(dstCity, distance);
            railwayMap.put(srcCity, otherCity);
        } else {
            Map<String, String> temp = new HashMap<String, String>();
            temp.put(dstCity, distance);
            railwayMap.put(srcCity, temp);
        }
    }

    private int getDistance(String start, String finish) throws Exception {
        if (start.equals(finish)) {
            return 0;
        }
        if (railwayMap.containsKey(start)) {
            for (Map.Entry<String, String> entry : railwayMap.get(start).entrySet()) {
                if (entry.getKey().equals(finish)) {
                    return Integer.valueOf(entry.getValue());
                }
            }
        }
        throw new Exception("not found");
    }

    public Map<String, Map<String, String>> getRailwayMap() {
        return railwayMap;
    }

    public boolean mapLoader(String map) {
        oriMap = map;
        if (!map.isEmpty()) {
            for (String path : map.split(",")) {
                setPathInfo(path);
            }
            return true;
        }
        return false;
    }

    public int getPathDistance(String path) throws Exception{
        int index = 0;
        int distance = 0;
        while (index + 1 < path.length()) {
            try {
                distance += getDistance(String.valueOf(path.charAt(index)), String.valueOf(path.charAt(index + 1)));
            }   catch (Exception e) {
                return -1;
            }
            index++;
        }
        return distance;
    }


    public ArrayList<ArrayList<String>> getPath(String start, String finish) {
        pathResolver.buildDFSTree(start, railwayMap);
        pathResolver.getAllPath(finish, pathResolver.getRoot(), new ArrayList<String>());

        return pathResolver.getPathList();
    }

    public int getPathNum(String start, String finish) {
        getPath(start, finish);
        return pathResolver.getPathNum();
    }
}
