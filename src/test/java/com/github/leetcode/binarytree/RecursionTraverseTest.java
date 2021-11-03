package com.github.leetcode.binarytree;

import org.junit.Test;

public class RecursionTraverseTest {

    private Node<Integer> builderBinaryTree() {
        Node<Integer> node2 = new Node<>(2,new Node<>(4,null,null),new Node<>(5,null,null));
        Node<Integer> node5 = new Node<>(3,new Node<>(6,null,null),new Node<>(7,null,null));
        Node<Integer> head = new Node<>(1,node2,node5);
        return head;
    }

    @Test
    public void testReOrder() {
        RecursionTraverse traverse = new RecursionTraverse();
        traverse.reOrderPrintln(builderBinaryTree());
    }

    @Test
    public void testMiddleOrder() {
        RecursionTraverse traverse = new RecursionTraverse();
        traverse.middleOrderPrintln(builderBinaryTree());
    }

    @Test
    public void testLastOrder() {
        RecursionTraverse traverse = new RecursionTraverse();
        traverse.lastOrderPrintln(builderBinaryTree());
    }

    @Test
    public void testWith() {
        RecursionTraverse traverse = new RecursionTraverse();
        traverse.widthPrintln(builderBinaryTree());
    }

}
