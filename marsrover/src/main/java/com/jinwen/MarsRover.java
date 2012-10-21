package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRover implements Robert{
    private int xPosition;
    private int yPosition;
    private Direction direction;

    private GenericMap map = null;

    public void setMapForMarsRover(GenericMap map) {
        this.map = map;
    }

    public MarsRover(int x, int y, char direction) {
        this.xPosition = x;
        this.yPosition = y;
        this.direction = new Direction(direction);
    }

    @Override
    public int move() {
        if (map == null) {
            return -1;
        }
        if (direction.getDirection() == 'E') {
            return (xPosition + 1) > map.getWidth() ? map.getWidth() : xPosition++;
        }else if (direction.getDirection() == 'W') {
            return (xPosition - 1) < 0 ? 0 : xPosition--;
        }else if (direction.getDirection() == 'S') {
            return (yPosition - 1) < 0 ? 0 : yPosition--;
        }else {
            return (yPosition + 1) > map.getHeight() ? map.getHeight() : yPosition++;
        }
    }

    public void changeDirection(char command) {
        if (command == 'L') {
            direction.turnLeft();
        }else {
            direction.turnRight();
        }
    }

    public String getLocation() {
        return Integer.toString(xPosition) + ", " + Integer.toString(yPosition) + " " + direction.getDirection() + "\n";
    }

    public void execute(char command) {
        if (command == 'M') {
            move();
        } else if (command == 'L' || command == 'R') {
            changeDirection(command);
        }
    }
}
