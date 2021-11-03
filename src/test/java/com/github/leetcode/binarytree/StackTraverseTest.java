package com.github.leetcode.binarytree;

import org.junit.Test;

public class StackTraverseTest {

    private Node<Integer> builderBinaryTree() {
        Node<Integer> node2 = new Node<>(2,new Node<>(4,null,null),new Node<>(5,new Node<Integer>(10,null,null),null));
        Node<Integer> node5 = new Node<>(3,new Node<>(6,null,null),new Node<>(7,null,new Node<Integer>(11,null,null)));
        Node<Integer> head = new Node<>(1,node2,node5);
        return head;
    }

    @Test
    public void testReOrdertraverse() {
        StackTraverse stackTraverse = new StackTraverse();
        stackTraverse.reOrderTraverse(builderBinaryTree());
    }

    @Test
    public void testlasttraverse() {
        StackTraverse stackTraverse = new StackTraverse();
        stackTraverse.lastTraverse(builderBinaryTree());
    }

    @Test
    public void testmiddleTraverse() {
        StackTraverse stackTraverse = new StackTraverse();
        stackTraverse.middleTraverse(builderBinaryTree());
    }
}
