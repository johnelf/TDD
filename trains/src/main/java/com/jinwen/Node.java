package com.jinwen;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/29/12
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    public String name;
    public List<Node> children = new LinkedList<Node>();
    public Node parent;

    Node(String name) {
        this.name = name;
    }
}
