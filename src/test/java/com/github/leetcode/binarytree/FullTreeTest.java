package com.github.leetcode.binarytree;

import org.junit.Test;

public class FullTreeTest {

    private Node<Integer> builderBinaryTree() {
        Node<Integer> node2 = new Node<>(7,new Node<>(6,null,null),new Node<>(8,null,null));
        Node<Integer> node5 = new Node<>(12,new Node<>(11,null,null),new Node<>(13,null,null));
        Node<Integer> head = new Node<>(10,node2,node5);
        return head;
    }

    @Test
    public void testFull2() {
        FullTree fullTree = new FullTree();

        assert fullTree.full2(builderBinaryTree());
    }


    @Test
    public void testFull1() {
        FullTree fullTree = new FullTree();

        assert fullTree.full1(builderBinaryTree());
    }
}
