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
    private Map<CityName, Map<CityName, String>> railwayMap = new HashMap<CityName, Map<CityName, String>>();
    private String mapName = "";

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public boolean isMapExist(){
        return !railwayMap.isEmpty();
    }

    public boolean mapLoader(String map){
        if (!map.isEmpty()){
            Map<CityName, String> otherCity = new HashMap<CityName, String>();
            otherCity.put(CityName.CHENGDU, "5");
            railwayMap.put(CityName.BEIJING, otherCity);
        }

        return true;
    }

    public List<String> getRoute(String start, String finish) {
        return null;
    }

    public int getDistance(String path) {
        return 0;
    }
}
