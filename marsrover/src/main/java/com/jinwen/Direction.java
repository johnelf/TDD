package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/21/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Direction {
    private char direction;

    Direction(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;
    }

    public void turnRight() {
        switch (direction) {
            case 'E':
                direction = 'S';
                break;
            case 'N':
                direction = 'E';
                break;
            case 'W':
                direction = 'N';
                break;
            case 'S':
                direction = 'W';
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case 'E':
                direction = 'N';
                break;
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
        }
    }

}
