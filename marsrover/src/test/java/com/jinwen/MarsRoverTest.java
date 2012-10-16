package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverTest {
    private MarsRover marsRover;
    private GeographerOnMars geographerOnMars;

    @Before
    public void setup() {
        marsRover = new MarsRover(1, 2, Direction.N);
        geographerOnMars = new GeographerOnMars("TestMap", 5, 5);
        marsRover.getMapForMarsRover(geographerOnMars);
    }

    @Test
    public void shouldReturnRealPosition() {
        marsRover.move();
        assertEquals("1, 3 ", marsRover.getLocation());
        marsRover.move();
        assertEquals("1, 4 ", marsRover.getLocation());
        marsRover.move();
        assertEquals("1, 5 ", marsRover.getLocation());
        marsRover.move();
        assertEquals("1, 5 ", marsRover.getLocation());
    }

    @Test
    public void shouldReturnCorrectDirection() {
        marsRover.changeDirection("L");
        assertEquals("W\n", marsRover.getDirection());
        marsRover.changeDirection("R");
        assertEquals("N\n", marsRover.getDirection());
        marsRover.changeDirection("R");
        assertEquals("E\n", marsRover.getDirection());
        marsRover.changeDirection("R");
        assertEquals("S\n", marsRover.getDirection());
    }
}
