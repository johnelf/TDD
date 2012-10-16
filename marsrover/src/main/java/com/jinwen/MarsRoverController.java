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

    public boolean getCurrentMarsRoverStatus() {
        return currentMarsRover != null && currentMarsRover.isMarsRoverWorking();
    }

    public MarsRover connectWithMarsRover(MarsRover marsRover) {
        if (currentMarsRover == null) {
            marsRover.startWorking();
            return currentMarsRover = marsRover;
        } else if (!currentMarsRover.isMarsRoverWorking()) {
            currentMarsRover = marsRover;
            currentMarsRover.startWorking();
            return currentMarsRover;
        } else {
            return currentMarsRover;
        }
    }

    public boolean disConnectWithCurrentMarsRover() {
        if (currentMarsRover != null) {
            currentMarsRover.finishWorking();
            return true;
        } else {
            return false;
        }
    }

    public MarsRover getNextMarsRover() {
        if (!marsRovers.isEmpty() || currentMarsRover != null) {
            if (currentMarsRover.isMarsRoverWorking()) {
                return getCurrentMarsRover();
            } else {
                currentMarsRover = marsRovers.get((marsRovers.indexOf(currentMarsRover) + 1) % marsRovers.size());
                return currentMarsRover;
            }
        }
        return null;
    }

    public String inputCommand(String command) {
        if (getCurrentMarsRover() != null) {
            int index = 0;
            while (index < command.length()) {
                String roverCommand = (((index + 1) < command.length()) ? command.substring(index++, index) : command.substring(index++));
                if (roverCommand.equals("M")) {
                    currentMarsRover.move();
                } else {
                    currentMarsRover.changeDirection(roverCommand);
                }
            }
        }
        return getCurrentRoverLocationAndDirection();
    }

    private String getCurrentRoverLocationAndDirection() {
        if (getCurrentMarsRover() != null) {
            return currentMarsRover.getLocation() + currentMarsRover.getDirection();
        }
        return null;
    }
}
