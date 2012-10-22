package com.jinwen;

public class RoverStatus {
    private Direction direction;
    private Position position;

    RoverStatus(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public void turnLeft() {
        direction = direction.left();
    }

    public void turnRight() {
        direction = direction.right();
    }

    public void moveOn(GenericMap map) {
        direction.move(map, position);
    }

    public String toString() {
        return position + " " + direction + "\n";
    }
}
