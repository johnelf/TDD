package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/23/12
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Command {
    M('M') {
        @Override
        public void execute(LocationWithDirection roverLocation, Location mapBoundry) {
            roverLocation.getDirection().move(roverLocation, mapBoundry);
        }
    },
    L('L') {
        @Override
        public void execute(LocationWithDirection roverLocation, Location mapBoundry) {
            roverLocation.setDirection(roverLocation.getDirection().turnL());
        }
    },
    R('R') {
        @Override
        public void execute(LocationWithDirection roverLocation, Location mapBoundry) {
            roverLocation.setDirection(roverLocation.getDirection().turnR());
        }
    };

    public char command;

    Command(char command) {
        this.command = command;
    }

    public abstract void execute(LocationWithDirection roverLocation, Location mapBoundry);
}
