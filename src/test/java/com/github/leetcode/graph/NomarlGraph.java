package com.github.leetcode.graph;

import java.util.Arrays;

public class NomarlGraph extends Graph<String> {

    public NomarlGraph() {
        super();
        init();
    }

    public void init() {
        Node<String> nodeA = new Node<>();
        Node<String> nodeB = new Node<>();
        Node<String> nodeC = new Node<>();
        Node<String> nodeD = new Node<>();
        Node<String> nodeE = new Node<>();
        Node<String> nodeF = new Node<>();
        nodeA.value = "A";
        nodeA.in = 2;
        nodeA.out = 2;
        nodeA.nextNodes = Arrays.asList(nodeB, nodeC);
        nodeA.edges = Arrays.asList(new Edge<>(nodeA,nodeB,7), new Edge<>(nodeA, nodeC,9));
        nodeB.value = "B";
        nodeB.in = 3;
        nodeB.out = 3;
        nodeB.nextNodes = Arrays.asList(nodeA,nodeD,nodeE);
        nodeB.edges = Arrays.asList(new Edge<>(nodeB,nodeA,7), new Edge<>(nodeB, nodeD, 10), new Edge<>(nodeB, nodeE, 6));
        nodeC.value = "C";
        nodeC.in = 3;
        nodeC.out = 3;
        nodeC.nextNodes = Arrays.asList(nodeA,nodeD,nodeF);
        nodeC.edges = Arrays.asList(new Edge<>(nodeC,nodeA,9), new Edge<>(nodeC, nodeD, 2), new Edge<>(nodeC, nodeF, 4));
        nodeD.value = "D";
        nodeD.in = 2;
        nodeD.out = 2;
        nodeD.nextNodes = Arrays.asList(nodeB,nodeC);
        nodeD.edges = Arrays.asList(new Edge<>(nodeD,nodeB,10), new Edge<>(nodeD, nodeC, 2));
        nodeE.value = "E";
        nodeE.in = 1;
        nodeE.out = 1;
        nodeE.nextNodes = Arrays.asList(nodeB);
        nodeE.edges = Arrays.asList(new Edge<>(nodeE,nodeB,6));
        nodeF.value = "F";
        nodeF.in = 1;
        nodeF.out = 1;
        nodeF.nextNodes = Arrays.asList(nodeC);
        nodeF.edges = Arrays.asList(new Edge<>(nodeF,nodeC,4));
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
        nodes.put("F",nodeF);
        edges.addAll(nodeF.edges);
    }

}
