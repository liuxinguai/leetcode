package com.github.leetcode.graph;

import org.junit.Test;

public class TraverseTest {

    private static void accept(Node<String> node) {
        System.out.println(node.value);
    }

    @Test
    public void test() {
        Traverse traverse = new Traverse();
        NomarlGraph graph = new NomarlGraph();
        System.out.println("graph breadth traverse");
        traverse.breadth(graph.nodes.get("A"), TraverseTest::accept);
        System.out.println("graph depth traverse");
        traverse.depth(graph.nodes.get("A"), TraverseTest::accept);
    }
}
