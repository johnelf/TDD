package com.jinwen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 10:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRoverController {
    private List<MarsRover> marsRovers = new ArrayList<MarsRover>();
    private MarsRover currentMarsRover = null;

    public void addMarsRover(MarsRover marsRover) {
        marsRovers.add(marsRover);
    }

    public MarsRover getCurrentMarsRover() {
        return currentMarsRover == null ? null : this.currentMarsRover;
    }

    public void setCurrentMarsRover(MarsRover marsRover) {
        this.currentMarsRover = marsRover;
        this.currentMarsRover.startWorking();
    }

    public MarsRover getNextMarsRover() {
        if (!marsRovers.isEmpty()) {
            this.currentMarsRover.finishWorking();
            return marsRovers.get((marsRovers.indexOf(currentMarsRover) + 1) % marsRovers.size());
        }
        return null;
    }

    public void inputCommand(String command) {
        if (getCurrentMarsRover() != null) {
            int index = 0;
            while (index < command.length()) {
                String roverCommand = command.substring(index++, index + 1);
                if (roverCommand.equals("M")) {
                    currentMarsRover.move();
                }else {
                    currentMarsRover.changeDirection(roverCommand);
                }
            }
        }
    }

    public String getCurrentRoverLocationAndDirection() {
        if (getCurrentMarsRover() != null) {
            return currentMarsRover.getLocation() + currentMarsRover.getDirection();
        }
        return null;
    }
}
