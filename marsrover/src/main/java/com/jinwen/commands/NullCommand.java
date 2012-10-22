package com.jinwen.commands;

import com.jinwen.RoverStatus;
import com.jinwen.commands.Command;

public class NullCommand implements Command {
    @Override
    public void execute(RoverStatus status) {
        //Do nothing
    }

}
