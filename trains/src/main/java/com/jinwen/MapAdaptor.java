package com.jinwen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 11:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapAdaptor extends RailwayMap{
    public boolean loadMap(String map){
        super.mapLoader(map);
        return true;
    }

    public List<String> showRoute(String start, String finish){
        return super.getRoute(start, finish);
    }

    public int getDistance(String path){
        return super.getDistance(path);
    }
}
