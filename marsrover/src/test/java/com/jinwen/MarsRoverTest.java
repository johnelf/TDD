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
        marsRover.setMapForMarsRover(geographerOnMars);
    }

    @Test
    public void shouldReturnRealPosition() {
        marsRover.execute(Command.M);
        assertEquals("1, 3 N\n", marsRover.getLocation());
        marsRover.execute(Command.M);
        assertEquals("1, 4 N\n", marsRover.getLocation());
        marsRover.execute(Command.M);
        assertEquals("1, 5 N\n", marsRover.getLocation());
        marsRover.execute(Command.M);
        assertEquals("1, 5 N\n", marsRover.getLocation());
    }

    @Test
    public void shouldReturnProperDirection() {
        marsRover.execute(Command.R);
        assertEquals("1, 2 E\n", marsRover.getLocation());
        marsRover.execute(Command.L);
        assertEquals("1, 2 N\n", marsRover.getLocation());
    }
}
