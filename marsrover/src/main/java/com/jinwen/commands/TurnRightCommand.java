package com.jinwen.commands;

import com.jinwen.RoverStatus;
import com.jinwen.commands.Command;

public class TurnRightCommand implements Command {
    @Override
    public void execute(RoverStatus status) {
        status.turnRight();
    }
}
