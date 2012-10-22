package com.jinwen.commands;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/16/12
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CommandInterceptor {
    public boolean interceptCommand(String command);
}
