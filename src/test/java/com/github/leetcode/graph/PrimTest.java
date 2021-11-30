package com.github.leetcode.graph;

import org.junit.Test;


public class PrimTest {

    @Test
    public void test() {
        NomarlGraph graph = new NomarlGraph();
        Prim prim = new Prim();
        prim.generalMinTree(graph).forEach(stringEdge -> System.out.println(stringEdge.from.value + "->" + stringEdge.to.value + ", weght : "+stringEdge.weight));
    }
}
