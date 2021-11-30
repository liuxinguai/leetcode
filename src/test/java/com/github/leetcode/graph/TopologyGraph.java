package com.github.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class TopologyGraph extends Graph<String> {

    public TopologyGraph() {
        super();
        init();
    }

    protected void init() {
        Node<String> nodeA = new Node<>();
        Node<String> nodeB = new Node<>();
        Node<String> nodeC = new Node<>();
        Node<String> nodeD = new Node<>();
        Node<String> nodeE = new Node<>();
        nodeA.value = "A";
        nodeA.in = 1;
        nodeA.out = 1;
        nodeA.nextNodes = Arrays.asList(nodeB);
        nodeA.edges = Arrays.asList(new Edge<>(nodeA,nodeB,3));
        nodeB.value = "B";
        nodeB.in = 2;
        nodeB.out = 1;
        nodeB.nextNodes = Arrays.asList(nodeC);
        nodeB.edges = Arrays.asList(new Edge<>(nodeB,nodeC,4));
        nodeC.value = "C";
        nodeC.in = 1;
        nodeC.out = 0;
        nodeC.nextNodes = new ArrayList<>();
        nodeC.edges = new ArrayList<>();
        nodeD.value = "D";
        nodeD.in = 1;
        nodeD.out = 1;
        nodeD.nextNodes = Arrays.asList(nodeB);
        nodeD.edges = Arrays.asList(new Edge<>(nodeD,nodeB,5));
        nodeE.value = "E";
        nodeE.in = 0;
        nodeE.out = 2;
        nodeE.nextNodes = Arrays.asList(nodeA,nodeD);
        nodeE.edges = Arrays.asList(new Edge<>(nodeE,nodeA,1),new Edge<>(nodeE,nodeD,2));

        nodes.put("A",nodeA);
        edges.addAll(nodeA.edges);
        nodes.put("B",nodeB);
        edges.addAll(nodeB.edges);
        nodes.put("C",nodeC);
        edges.addAll(nodeC.edges);
        nodes.put("D",nodeD);
        edges.addAll(nodeD.edges);
        nodes.put("E",nodeE);
        edges.addAll(nodeE.edges);
    }

}
