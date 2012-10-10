package com.jinwen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayHelper {
    private RailwayMap railwayMap = new RailwayMap();
    private MapAdaptor mapAdaptor;

    public RailwayHelper(String map){
        mapAdaptor.mapLoader(map);
    }

    public String getDistance(String route){
        if (!railwayMap.isMapExist()){
            return null;
        }
        int distance = railwayMap.getDistance(route);
        return Integer.toString(distance);
    }

    public List<String> getRoute(String start, String finish){
        if (!railwayMap.isMapExist()){
            return null;
        }
        return railwayMap.getRoute(start, finish);
    }
}
