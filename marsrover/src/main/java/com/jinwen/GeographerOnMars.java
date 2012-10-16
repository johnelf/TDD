package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeographerOnMars implements GenericMap{
    private final int width;
    private final int height;
    private String mapName = "unamed";

    public GeographerOnMars(String mapName, int width, int height) {
        this.width = width;
        this.height = height;
        this.mapName = mapName;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
