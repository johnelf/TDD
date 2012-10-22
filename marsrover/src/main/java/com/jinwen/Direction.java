package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/21/12
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Direction {
    W {
        @Override
        protected void move(GenericMap map, Position position) {
            if (position.getxPosition() - 1 >= 0) position.decreaseX();
        }
    },
    N {
        @Override
        protected void move(GenericMap map, Position position) {
            if (position.getyPosition() + 1 <= map.getHeight()) position.increaseY();
        }
    },
    E {
        @Override
        protected void move(GenericMap map, Position position) {
            if (position.getxPosition() + 1 <= map.getWidth()) position.increaseX();
        }
    },
    S {
        @Override
        protected void move(GenericMap map, Position position) {
            if (position.getyPosition() - 1 >= 0) position.decreaseY();
        }
    };


    abstract protected void move(GenericMap map, Position position);

    public Direction right() {
        int i = (ordinal() + 1) % values().length;
        return Direction.values()[i];
    }

    public Direction left() {
        int i = (ordinal() + values().length - 1) % values().length;
        return Direction.values()[i];
    }

}
