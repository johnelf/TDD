package com.main;

import com.jinwen.*;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 11:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMain {
    public static void main() {

        MarsRover marsRover1 = new MarsRover(1, 2, Direction.N);
        MarsRover marsRover2 = new MarsRover(3, 3, Direction.E);

        RoverConsole roverConsole = new RoverConsole(new GeographerAdaptor("MarsPlateau", 5, 5), new MarsRoverController());

        marsRover1.getMapForMarsRover(roverConsole.geographerAdaptor);
        marsRover2.getMapForMarsRover(roverConsole.geographerAdaptor);

        roverConsole.marsRoverController.addMarsRover(marsRover1);
        roverConsole.marsRoverController.addMarsRover(marsRover2);

        roverConsole.marsRoverController.connectWithMarsRover(marsRover1);
        roverConsole.marsRoverController.inputCommand("LMLMLMLMM");
        roverConsole.marsRoverController.getNextMarsRover();
        roverConsole.marsRoverController.inputCommand("MMRMMRMRRM");

    }
}
