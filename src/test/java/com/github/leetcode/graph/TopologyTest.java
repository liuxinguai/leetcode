package com.github.leetcode.graph;

import org.junit.Test;


public class TopologyTest {

    @Test
    public void test() {
        TopologyGraph topologyGraph = new TopologyGraph();
        Topology topology = new Topology();
        topology.getNoRelyNodes(topologyGraph).forEach(node -> System.out.println(node.value));
    }
}
