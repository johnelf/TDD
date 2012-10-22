package com.jinwen;

public class MarsRover implements Robert{
    private Direction direction;
    private GenericMap map = null;
    private Position position;

    public void setMapForMarsRover(GenericMap map) {
        this.map = map;
    }

    public MarsRover(int x, int y, char direction) {
        this.position = new Position(x, y);
        this.direction = Direction.valueOf(String.valueOf(direction));
    }

    @Override
    public void move() {
        if (map == null) {
            return;
        }

        direction.move(map, position);
    }

    public void changeDirection(char command) {
        if (command == 'L') {
            direction = direction.left();
        }else {
            direction = direction.right();
        }
    }

    public String getLocation() {
        return Integer.toString(position.getxPosition()) + ", " + Integer.toString(position.getyPosition()) + " " + direction + "\n";
    }

    public void execute(char command) {
        if (command == 'M') {
            move();
        } else if (command == 'L' || command == 'R') {
            changeDirection(command);
        }
    }
}
