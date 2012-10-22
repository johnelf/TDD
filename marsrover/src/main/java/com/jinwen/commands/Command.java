package com.jinwen.commands;

import com.jinwen.RoverStatus;

public interface Command {
    public void execute(RoverStatus status);

}
