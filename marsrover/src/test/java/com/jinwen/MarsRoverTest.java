package com.jinwen;

import com.jinwen.commands.MoveCommand;
import com.jinwen.commands.TurnLeftCommand;
import com.jinwen.commands.TurnRightCommand;
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
        marsRover = new MarsRover(1, 2, "N");
        geographerOnMars = new GeographerOnMars("TestMap", 5, 5);
        marsRover.setMapForMarsRover(geographerOnMars);
    }

    @Test
    public void shouldReturnRealPosition() {
        new MoveCommand(geographerOnMars).execute(marsRover.getStatus());
        assertEquals("1, 3 N\n", marsRover.toString());
        new MoveCommand(geographerOnMars).execute(marsRover.getStatus());
        assertEquals("1, 4 N\n", marsRover.toString());
        new MoveCommand(geographerOnMars).execute(marsRover.getStatus());
        assertEquals("1, 5 N\n", marsRover.toString());
        new MoveCommand(geographerOnMars).execute(marsRover.getStatus());
        assertEquals("1, 5 N\n", marsRover.toString());
    }

    @Test
    public void shouldReturnProperDirection() {
        new TurnRightCommand().execute(marsRover.getStatus());
        assertEquals("1, 2 E\n", marsRover.toString());
        new TurnLeftCommand().execute(marsRover.getStatus());
        assertEquals("1, 2 N\n", marsRover.toString());
    }
}
