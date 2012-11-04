package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

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
    public void setup() {
        railwayMap = new RailwayMap();
        railwayMap.mapLoader("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");
    }

    @Test
    public void shouldLoadMapCorrectly() {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap = railwayMap.getRailwayMap().get("A");
        for (Map.Entry<String, String> item : testMap.entrySet()) {
            if (item.getKey().equals("D")) {
                assertEquals("5", item.getValue());
            }
            if (item.getKey().equals("E")) {
                assertEquals("7", item.getValue());
            }
            if (item.getKey().equals("B")) {
                assertEquals("5", item.getValue());
            }
        }
        testMap = railwayMap.getRailwayMap().get("B");
        for (Map.Entry<String, String> item : testMap.entrySet()) {
            if (item.getKey().equals("C")) {
                assertEquals("4", item.getValue());
            }
        }
        testMap = railwayMap.getRailwayMap().get("C");
        for (Map.Entry<String, String> item : testMap.entrySet()) {
            if (item.getKey().equals("D")) {
                assertEquals("8", item.getValue());
            }
            if (item.getKey().equals("E")) {
                assertEquals("2", item.getValue());
            }
        }
        testMap = railwayMap.getRailwayMap().get("D");
        for (Map.Entry<String, String> item : testMap.entrySet()) {
            if (item.getKey().equals("C")) {
                assertEquals("8", item.getValue());
            }
            if (item.getKey().equals("E")) {
                assertEquals("6", item.getValue());
            }
        }
        testMap = railwayMap.getRailwayMap().get("E");
        for (Map.Entry<String, String> item : testMap.entrySet()) {
            if (item.getKey().equals("B")) {
                assertEquals("3", item.getValue());
            }
        }
    }

    @Test
    public void shouldShowTheDistanceOfThePath() throws Exception {
        assertEquals(9, railwayMap.getPathDistance("ABC"));
        assertEquals(5, railwayMap.getPathDistance("AD"));
        assertEquals(13, railwayMap.getPathDistance("ADC"));
        assertEquals(22, railwayMap.getPathDistance("AEBCD"));
        assertEquals(-1, railwayMap.getPathDistance("AED"));
    }

    @Test
    public void shouldGetAllPaths() {
        assertEquals(3, railwayMap.getPathNum("C", "C"));
        assertEquals(4, railwayMap.getPathNum("A", "C"));
    }
}
