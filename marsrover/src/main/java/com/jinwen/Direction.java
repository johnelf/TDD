package com.jinwen;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/15/12
 * Time: 9:21 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Direction {
    E("East"), N("North"), W("West"), S("South");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }
}
