package com.github.leetcode.graph;

import org.junit.Test;

public class KruskalTest {

    @Test
    public void test() {
        NomarlGraph graph = new NomarlGraph();
        Kruskal kruskal = new Kruskal();
        kruskal.generalMinTree(graph).forEach(stringEdge -> System.out.println(stringEdge.from.value + "->" + stringEdge.to.value + ", weight : "+stringEdge.weight));
    }
}
