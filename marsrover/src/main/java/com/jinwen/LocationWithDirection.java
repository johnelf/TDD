package com.jinwen;

public class LocationWithDirection extends Location{
    private Direction direction;

    public LocationWithDirection(int xPosition, int yPosition, Direction direction) {
        super(xPosition, yPosition);
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}