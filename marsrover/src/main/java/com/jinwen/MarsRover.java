package com.jinwen;

import com.jinwen.commands.CommandFactory;

public class MarsRover{
    private GenericMap map = null;
    private RoverStatus status;

    public void setMapForMarsRover(GenericMap map) {
        this.map = map;
    }

    public MarsRover(int x, int y, String direction) {
        status = new RoverStatus(Direction.valueOf(direction), new Position(x, y));
    }

    public void execute(char commandChar) {
        CommandFactory commandFactory = new CommandFactory(map);
        commandFactory.createCommand(commandChar).execute(status);
    }

    public RoverStatus getStatus() {
        return status;
    }

    public String toString() {
        return status.toString();
    }
}
