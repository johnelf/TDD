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
    private MapAdaptor mapAdaptor;

    public RailwayHelper(String map){
        mapAdaptor.mapLoader(map);
    }

    public String showDistance(String path){
        if (!mapAdaptor.isMapExist()){
            return null;
        }
        int distance = mapAdaptor.getDistance(path);
        return Integer.toString(distance);
    }

    public List<String> listAllPath(String start, String finish){
        if (!mapAdaptor.isMapExist()){
            return null;
        }
        return mapAdaptor.getRoute(start, finish);
    }

    public int getRouteNumber(String start, String finish){
        if (!mapAdaptor.isMapExist()){
            return -1;
        }
        List<String> searchResult = mapAdaptor.getRoute(start, finish);
        return searchResult.size();
    }

    public boolean isPathReachable(String path){
        if (mapAdaptor.getDistance(path) <= 0){
            return false;
        } else {
            return true;
        }
    }

    public boolean isCityReachable(String start, String finish){
        if (mapAdaptor.showRoute(start, finish).isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
