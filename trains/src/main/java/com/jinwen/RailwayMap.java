package com.jinwen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayMap implements Indicator{
    private Map<String, Map<String, String>> railwayMap = new HashMap<String, Map<String, String>>();

    public boolean isMapExist(){
        return railwayMap.isEmpty() ? false : true;
    }

    public boolean mapLoader(String map){
        return true;
    }

    public List<String> getRoute(String start, String finish) {
        return null;
    }

    public int getDistance(String route) {
        return 0;
    }
}
