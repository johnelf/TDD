package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 9:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class MarsRover {
    private LocationWithDirection location = new LocationWithDirection(0, 0, Direction.N);
    private GenericMap map = null;

    public void setMapForMarsRover(GenericMap map) {
        this.map = map;
    }

    public MarsRover(int x, int y, Direction direction) {
        this.location.setxPosition(x);
        this.location.setyPosition(y);
        this.location.setDirection(direction);
    }

    public String getLocation() {
        return Integer.toString(location.getxPosition()) + ", " + Integer.toString(location.getyPosition()) +
                " " + location.getDirection() + "\n";
    }

    public void execute(Command command) {
        if (map != null) {
            command.execute(location, new Location(map.getWidth(), map.getHeight()));
        }
    }
}
