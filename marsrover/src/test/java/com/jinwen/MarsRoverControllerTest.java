package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 11:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverControllerTest {
    private MarsRover marsRover1;
    private MarsRover marsRover2;
    private MarsRoverController marsRoverController;
    private GeographerOnMars geographerOnMars;

    @Before
    public void setup() {
        marsRover1 = new MarsRover(1, 2, Direction.N);
        marsRover2 = new MarsRover(3, 3, Direction.E);
        marsRoverController = new MarsRoverController();
        marsRoverController.addMarsRover(marsRover1);
        marsRoverController.addMarsRover(marsRover2);
        geographerOnMars = new GeographerOnMars("TestMap", 5, 5);
    }

    @Test
    public void shouldGetNextMarsRover() throws Exception {
        marsRoverController.connectWithMarsRover(marsRover1);
        marsRoverController.disConnectWithCurrentMarsRover();
        marsRoverController.getNextMarsRover();
        assertEquals(marsRover2, marsRoverController.getCurrentMarsRover());

        marsRoverController.connectWithMarsRover(marsRover2);
        marsRoverController.disConnectWithCurrentMarsRover();
        marsRoverController.getNextMarsRover();
        assertEquals(marsRover1, marsRoverController.getCurrentMarsRover());
    }

    @Test
    public void shouldNotGetNextMarsRoverWhenCurrentIsWorking() {
        marsRoverController.connectWithMarsRover(marsRover1);
        marsRoverController.getNextMarsRover();
        assertEquals(marsRover1, marsRoverController.getCurrentMarsRover());
    }

    @Test
    public void shouldNotMoveWhenMarsRoverHaveNoMap() {
        marsRoverController.connectWithMarsRover(marsRover1);
        assertEquals("1, 2 N\n", marsRoverController.inputCommand("LRRLM"));
    }

    @Test
    public void shouldExecuteCommandCorrectly() {
        marsRoverController.connectWithMarsRover(marsRover1);
        marsRover1.getMapForMarsRover(geographerOnMars);
        assertEquals("1, 3 N\n", marsRoverController.inputCommand("LRRLM"));
        assertEquals("1, 5 N\n", marsRoverController.inputCommand("LRRLMMMMMM"));
    }
}
