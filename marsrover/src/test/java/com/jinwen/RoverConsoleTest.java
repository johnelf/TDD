package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/17/12
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoverConsoleTest{
    private RoverConsole roverConsole;
    private MarsRover marsRover1 = new MarsRover(1, 2, Direction.N);
    private MarsRover marsRover2 = new MarsRover(3, 3, Direction.E);
    private GenericMap marsMap = new GeographerOnMars("Mars", 5, 5);

    @Before
    public void setup() {
        roverConsole = new RoverConsole();
    }

    @Test
    public void shouldReturnTrueWhenCommandIsValid() {
        assertEquals(true, roverConsole.interceptCommand("RLRLRLLRMMMMLMLRMRLMRLMRLMRLRMLRMLRMLRMLRM"));
    }

    @Test
    public void shouldReturnFalseWhenCommandIsInvalid() {
        assertEquals(false, roverConsole.interceptCommand("RLRLRLURMMMMLML RMRLMR?LMRLR12RML*^LRMLRM"));
    }

    @Test
    public void shouldNotGetMarsRover() {
        assertEquals(false, roverConsole.getMarsRover());
    }

    @Test
    public void shouldGetMarsRoverSuccessfully() {
        roverConsole.addMarsRover(marsRover1);
        roverConsole.addMarsRover(marsRover2);
        assertEquals(true, roverConsole.getMarsRover());
    }

    @Test
    public void shouldNotGetMarsRoverPositionAndLocationWhenCommandIsInvalid() {
        roverConsole.addMarsRover(marsRover1);
        roverConsole.addMarsRover(marsRover2);
        assertNull(roverConsole.inputCommandLine("LOP"));
    }

    @Test
    public void shouldGetMarsRoverPositionAndLocationWhenCommandIsValid() {
        marsRover1.setMapForMarsRover(marsMap);
        marsRover2.setMapForMarsRover(marsMap);
        roverConsole.addMarsRover(marsRover1);
        roverConsole.addMarsRover(marsRover2);
        assertEquals("1, 1 S\n", roverConsole.inputCommandLine("LLM"));
    }

    @Test
    public void shouldNotExecuteAnyCommandWhenNotGetMarsRover() {
        assertEquals(false, roverConsole.getMarsRover());
    }
}
