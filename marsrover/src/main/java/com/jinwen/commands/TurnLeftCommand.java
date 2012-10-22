package com.jinwen.commands;

import com.jinwen.RoverStatus;
import com.jinwen.commands.Command;

public class TurnLeftCommand implements Command {
    @Override
    public void execute(RoverStatus status) {
        status.turnLeft();
    }
}
