package com.jinwen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class RoverConsole implements CommandInterceptor{
    private List<MarsRover> marsRoverList = new ArrayList<MarsRover>();
    private int currentIndex;

    public RoverConsole() {
        currentIndex = 0;
    }

    @Override
    public boolean interceptCommand(String command) {
        if (command != null) {
            for (char var : command.toCharArray()) {
                if (var != 'L' && var != 'R' && var != 'M'){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean getMarsRover() {
        return !marsRoverList.isEmpty() && currentIndex  < marsRoverList.size();
    }

    public void addMarsRover(MarsRover marsRover) {
        marsRoverList.add(marsRover);
    }

    public String inputCommandLine(String command) {
        if (!interceptCommand(command) || !getMarsRover()) {
            return null;
        } else {
            MarsRover marsRover = marsRoverList.get(currentIndex);
            for (char var : command.toCharArray()) {
                marsRover.execute(Command.valueOf(String.valueOf(var)));
            }
            currentIndex++;
            return marsRover.getLocation();
        }
    }
}
