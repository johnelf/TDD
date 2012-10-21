package com.jinwen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jinwen.CityName.getCityName;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayMap implements Indicator {
    private Map<CityName, Map<CityName, String>> railwayMap = new HashMap<CityName, Map<CityName, String>>();
    private String mapName = "";

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public boolean isMapExist() {
        return !railwayMap.isEmpty();
    }

    public boolean mapLoader(String map) {
        if (!map.isEmpty()) {
            for (String path : map.split(",")) {
                setPathInfo(path);
            }
            return true;
        }
        return false;
    }

    private void setPathInfo(String path) {
        String srcCity = String.valueOf(path.charAt(0)),
               dstCity = String.valueOf(path.charAt(1)),
               distance = String.valueOf(path.charAt(2));
        Map<CityName, String> otherCity = new HashMap<CityName, String>();
        otherCity.put(getCityName(dstCity), distance);
        for (char data : path.toCharArray()) {

        }

        railwayMap.put(getCityName(srcCity), otherCity);
    }

    public List<String> getRoute(String start, String finish) {
        return null;
    }

    public int getDistance(String path) {
        return 0;
    }
}
