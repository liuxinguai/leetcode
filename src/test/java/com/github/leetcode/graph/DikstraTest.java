package com.github.leetcode.graph;

import org.junit.Test;

import java.util.Map;

public class DikstraTest {


    @Test
    public void test() {
        Graph<String> graph = new NomarlGraph();
        Dijkstra dijkstra = new Dijkstra();
        Node<String> nodeA = graph.nodes.get("A");
        Map<Node, Integer> map = dijkstra.minDistince(nodeA);
        map.forEach((node, integer) -> System.out.println(node.value + " : " + integer));
    }

}
