package com.jinwen;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayMapTest {
    private RailwayMap railwayMap;

    @Before
    public void setup(){
        railwayMap = new RailwayMap();
        railwayMap.setMapName("For Test");
    }

    @Test
    public void shouldListAllPaths() {
        railwayMap.getRoute("C", "A");

    }
}
