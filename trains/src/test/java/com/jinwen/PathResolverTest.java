package com.jinwen;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 11/4/12
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathResolverTest {
    private PathResolver pathResolver = new PathResolver();
    private Map<String, Map<String, String>> map= new HashMap<String, Map<String, String>>();

    @Before
    public void setup() {
        Map<String, String> element1 = new HashMap<String, String>();
        element1.put("B", "1");
        element1.put("D", "1");
        element1.put("E", "2");
        map.put("A", element1);
        Map<String, String> element2 = new HashMap<String, String>();
        element2.put("C", "1");
        map.put("B", element2);
        Map<String, String> element3 = new HashMap<String, String>();
        element3.put("D", "2");
        element3.put("E", "3");
        map.put("C", element3);
        Map<String, String> element4 = new HashMap<String, String>();
        element4.put("C", "2");
        element4.put("E", "3");
        map.put("D", element4);
        Map<String, String> element5 = new HashMap<String, String>();
        element5.put("B", "2");
        map.put("E", element5);
    }

    @Test
    public void shouldCreateCorrectTree() {
        String result = "";
        pathResolver.buildDFSTree("A", map);

        for (Node node : pathResolver.getRoot().children) {
            result += node.name;
        }
        assertEquals(true, result.contains("B"));
        assertEquals(true, result.contains("D"));
        assertEquals(true, result.contains("E"));

        List<Node> list = pathResolver.getRoot().children;
        for (Node node : list) {
            if (node.name.equals("B")) {
                assertEquals("C", node.children.get(0).name);
                assertEquals("D", node.children.get(0).children.get(0).name);
                assertEquals("E", node.children.get(0).children.get(0).children.get(0).name);
                assertEquals("E", node.children.get(0).children.get(1).name);

            }
            if (node.name.equals("D")) {
                assertEquals(2, node.children.size());
                assertEquals(true, node.children.get(0).name.equals("E"));
                assertEquals("B", node.children.get(0).children.get(0).name);
                assertEquals("C", node.children.get(0).children.get(0).children.get(0).name);
                assertEquals(true, node.children.get(1).name.equals("C"));
                assertEquals("E", node.children.get(1).children.get(0).name);
            }
            if (node.name.equals("E")) {
                assertEquals("B", node.children.get(0).name);
                assertEquals("C", node.children.get(0).children.get(0).name);
                assertEquals("D", node.children.get(0).children.get(0).children.get(0).name);
            }
        }
    }
}
