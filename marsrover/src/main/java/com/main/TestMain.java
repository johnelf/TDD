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
    public static void main(String args[]) {
        MarsRover marsRover1 = new MarsRover(1, 2, Direction.N);
        MarsRover marsRover2 = new MarsRover(3, 3, Direction.E);
        GeographerOnMars geographerOnMars = new GeographerOnMars("Mars", 5, 5);
        RoverConsole roverConsole = new RoverConsole();

        marsRover1.setMapForMarsRover(geographerOnMars);
        marsRover2.setMapForMarsRover(geographerOnMars);
        roverConsole.addMarsRover(marsRover1);
        roverConsole.addMarsRover(marsRover2);

        System.out.println(roverConsole.inputCommandLine("LMLMLMLMM"));
        System.out.println(roverConsole.inputCommandLine("MMRMMRMRRM"));

    }
}
