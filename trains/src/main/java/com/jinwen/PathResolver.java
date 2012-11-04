package com.jinwen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 10/31/12
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class PathResolver {
    private Map<String, String> visitedFlag = new HashMap<String, String>();
    private Node root;
    private ArrayList<ArrayList<String>> pathList = new ArrayList<ArrayList<String>>();

    public ArrayList<ArrayList<String>> getPathList() {
        return pathList;
    }

    public Node getRoot() {
        return root;
    }

    public void buildDFSTree(String start, Map<String, Map<String, String>> railwayMap) {
        root = new Node(start);
        visitedFlag.clear();
        for (Map.Entry<String, Map<String, String>> entry : railwayMap.entrySet()) {
            visitedFlag.put(entry.getKey(), "unvisited");
        }

        if (visitedFlag.get(start).equals("unvisited")) {
            DFS(railwayMap, root, visitedFlag);
        }
    }

    private void DFS(Map<String, Map<String, String>> railwayMap, Node start, Map<String, String> flag) {
        Map<String, String> setFlag = new HashMap<String, String>();

        for (Map.Entry<String, String> entry : railwayMap.get(start.name).entrySet()) {
            for (Map.Entry<String, Map<String, String>> mapEntry : railwayMap.entrySet()) {
                if (flag.get(mapEntry.getKey()).equals("visited")) {
                    setFlag.put(mapEntry.getKey(), "visited");
                } else {
                    setFlag.put(mapEntry.getKey(), "unvisited");
                }
            }
            if (setFlag.get(entry.getKey()).equals("unvisited")) {
                Node node = new Node(entry.getKey());
                node.parent = start;
                start.children.add(node);
                setFlag.put(entry.getKey(), "visited");
                DFS(railwayMap, node, setFlag);
            } else {
                if (entry.getKey().equals(root.name)) {
                    Node node = new Node(root.name);
                    node.parent = start;
                    start.children.add(node);
                }
            }
        }
    }

    public void getAllPath(String finish, Node currentNode, ArrayList<String> result) {
        pathList.clear();
        getPaths(finish, currentNode, result);
    }

    public void getPaths(String finish, Node currentNode, ArrayList<String> result) {
        if (currentNode != root && currentNode.name.equals(finish)) {
            result.add(currentNode.name);
            pathList.add(result);
        } else if (currentNode.children.size() > 0){
            result.add(currentNode.name);
            for (Node node : currentNode.children) {
                getPaths(finish, node, new ArrayList<String>(result));
            }
        } else {
            result.clear();
        }
    }

    public int getPathNum() {
        return pathList.size();
    }
}
