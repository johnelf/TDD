package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/12
 * Time: 8:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class RailwayAssistantTest {
    private RailwayAssistant railwayAssistant = new RailwayAssistant("AB5,BC4,CD8,DC8,DE6,AD5,CE2,EB3,AE7");

    @Before
    public void setup() {
    }

    @Test
    public void testGetStopsLessPathNum() throws Exception {
        assertEquals(2, railwayAssistant.getStopsLessPathNum("C", "C", 4));
    }

    @Test
    public void testGetExactStopNumber() throws Exception {
        assertEquals(3, railwayAssistant.getExactStopNumber("A", "C", 4));
    }

    @Test
    public void testGetShortestPath() throws Exception {
        assertEquals(9, railwayAssistant.getShortestPath("A", "C"));
    }

//    @Test
//    public void testGetPathsDistanceLessThan() throws Exception {
//        assertEquals(7, railwayAssistant.getDistanceLessThanPathsNum("C", "C", 30));
//    }
}
