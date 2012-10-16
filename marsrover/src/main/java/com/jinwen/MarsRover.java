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
    private boolean status = false;

    private GenericMap map = null;

    public void getMapForMarsRover(GenericMap map) {
        this.map = map;
    }

    public boolean isMarsRoverWorking() {
        return status;
    }

    public void startWorking() {
        this.status = true;
    }

    public void finishWorking() {
        this.status = false;
    }

    public MarsRover(int x, int y, Direction direction) {
        this.xPosition = x;
        this.yPosition = y;
        this.direction = direction;
    }

    @Override
    public int move() {
        if (map == null) {
            return -1;
        }
        if (direction.equals(Direction.E)) {
            return (xPosition + 1) > map.getWidth() ? map.getWidth() : xPosition++;
        }else if (direction.equals(Direction.W)) {
            return (xPosition - 1) < 0 ? 0 : xPosition--;
        }else if (direction.equals(Direction.S)) {
            return (yPosition - 1) < 0 ? 0 : yPosition--;
        }else {
            return (yPosition + 1) > map.getHeight() ? map.getHeight() : yPosition++;
        }
    }

    public void changeDirection(String command) {
        if (command.equals("L")) {
            turnLeft();
        }else {
            turnRight();
        }
    }

    private void turnRight() {
        switch (direction.ordinal()) {
            case 0:
                direction = Direction.S;
                break;
            case 1:
                direction = Direction.E;
                break;
            case 2:
                direction = Direction.N;
                break;
            case 3:
                direction = Direction.W;
                break;
        }
    }

    private void turnLeft() {
        switch (direction.ordinal()) {
            case 0:
                direction = Direction.N;
                break;
            case 1:
                direction = Direction.W;
                break;
            case 2:
                direction = Direction.S;
                break;
            case 3:
                direction = Direction.E;
                break;
        }
    }

    public String getLocation() {
        return Integer.toString(this.xPosition) + ", " + Integer.toString(this.yPosition) + " ";
    }

    public String getDirection() {
        return direction.toString() + "\n";
    }

}
