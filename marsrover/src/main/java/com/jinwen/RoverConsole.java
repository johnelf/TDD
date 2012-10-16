package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoverConsole implements CommandInterceptor{
    public GeographerAdaptor geographerAdaptor;
    public MarsRoverController marsRoverController;

    public RoverConsole(GeographerAdaptor geographerAdaptor, MarsRoverController marsRoverController) {
        this.geographerAdaptor = geographerAdaptor;
        this.marsRoverController = marsRoverController;
    }

    @Override
    public void interceptCommand(String command) {
        if (command != null) {

        }
    }
}
