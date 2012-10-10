package com.jinwen;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/10/12
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Indicator {
    public List<String> getRoute(String start, String finish);
    public int getDistance(String route);
}
