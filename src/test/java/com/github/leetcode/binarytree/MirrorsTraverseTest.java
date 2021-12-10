package com.github.leetcode.binarytree;

import org.junit.Test;

public class MirrorsTraverseTest {

    private Node<Integer> builderBinaryTree() {
        Node<Integer> node2 = new Node<>(7,new Node<>(6,null,null),new Node<>(8,null,null));
        Node<Integer> node5 = new Node<>(12,new Node<>(11,null,null),new Node<>(13,null,null));
        Node<Integer> head = new Node<>(10,node2,node5);
        return head;
    }

    @Test
    public void testPreorder() {
        MirrorsTraverse mirrorsTraverse = new MirrorsTraverse();
        mirrorsTraverse.preorder(builderBinaryTree());
    }

    @Test
    public void testMiddleorder() {
        MirrorsTraverse mirrorsTraverse = new MirrorsTraverse();
        mirrorsTraverse.middleorder(builderBinaryTree());
    }


    @Test
    public void testpostorder() {
        MirrorsTraverse mirrorsTraverse = new MirrorsTraverse();
        mirrorsTraverse.postorder(builderBinaryTree());
    }

}
