package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/22/12
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Direction {
    W('W') {
        @Override
        public void move(LocationWithDirection roverLocation, Location mapBoundry) {
            if ((roverLocation.getxPosition() - 1) >= 0) {
                roverLocation.setxPosition(roverLocation.getxPosition() - 1);
            }
        }

        @Override
        public Direction turnL() {
            return Direction.S;
        }

        @Override
        public Direction turnR() {
            return Direction.N;
        }
    },
    E('E') {
        @Override
        public void move(LocationWithDirection roverLocation, Location mapBoundry) {
            if ((roverLocation.getxPosition() + 1) <= mapBoundry.getxPosition()) {
                roverLocation.setxPosition(roverLocation.getxPosition() + 1);
            }
        }

        @Override
        public Direction turnL() {
            return Direction.N;
        }

        @Override
        public Direction turnR() {
            return Direction.S;
        }
    },
    S('S') {
        @Override
        public void move(LocationWithDirection roverLocation, Location mapBoundry) {
            if ((roverLocation.getyPosition() - 1) >= 0) {
                roverLocation.setyPosition(roverLocation.getyPosition() - 1);
            }
        }

        @Override
        public Direction turnL() {
            return Direction.E;
        }

        @Override
        public Direction turnR() {
            return Direction.W;
        }
    },
    N('N') {
        @Override
        public void move(LocationWithDirection roverLocation, Location mapBoundry) {
            if ((roverLocation.getyPosition() + 1) <= mapBoundry.getyPosition()) {
                roverLocation.setyPosition(roverLocation.getyPosition() + 1);
            }
        }

        @Override
        public Direction turnL() {
            return Direction.W;
        }

        @Override
        public Direction turnR() {
            return Direction.E;
        }
    };

    private char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public abstract Direction turnL();

    public abstract Direction turnR();

    public abstract void move(LocationWithDirection roverLocation, Location mapBoundry);
}
