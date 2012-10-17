package com.jinwen;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/17/12
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoverConsoleTest{
    @Test
    public void shouldReturnTrueWhenCommandIsValid() {
        RoverConsole roverConsole = new RoverConsole(new GeographerAdaptor("test", 5, 5), new MarsRoverController());
        assertEquals(true, roverConsole.interceptCommand("RLRLRLLRMMMMLMLRMRLMRLMRLMRLRMLRMLRMLRMLRM"));
    }

    @Test
    public void shouldReturnFalseWhenCommandIsInvalid() {
        RoverConsole roverConsole = new RoverConsole(new GeographerAdaptor("test", 5, 5), new MarsRoverController());
        assertEquals(false, roverConsole.interceptCommand("RLRLRLURMMMMLML RMRLMR?LMRLR12RML*^LRMLRM"));
    }
}
