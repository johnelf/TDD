package com.jinwen.commands;

import com.jinwen.GenericMap;
import com.jinwen.RoverStatus;
import com.jinwen.commands.Command;

public class MoveCommand implements Command {
    private GenericMap map;

    public MoveCommand(GenericMap map) {
        this.map = map;
    }

    @Override
    public void execute(RoverStatus status) {
        if (map != null) {
            status.moveOn(map);
        }
    }

}
