package com.jinwen;

public class Position {
    private  Integer xPosition;
    private Integer yPosition;

    public Integer getxPosition() {
        return xPosition;
    }

    public Integer getyPosition() {
        return yPosition;
    }

    public Position(Integer xPosition, Integer yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void decreaseX() {
        xPosition--;
    }

    public void increaseX() {
        xPosition++;
    }

    public void decreaseY() {
        yPosition--;
    }

    public void increaseY() {
        yPosition++;
    }

    @Override
    public String toString() {
        return xPosition + ", " + yPosition;
    }
}
