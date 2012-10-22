package com.jinwen.commands;

import com.jinwen.*;

public class CommandFactory {
    private GenericMap map;

    public CommandFactory(GenericMap map) {
        this.map = map;
    }

    public Command createCommand(char command) {
        switch (command) {
            case 'M': return new MoveCommand(map);
            case 'L': return new TurnLeftCommand();
            case 'R': return new TurnRightCommand();
        }
        return new NullCommand();
    }

}
