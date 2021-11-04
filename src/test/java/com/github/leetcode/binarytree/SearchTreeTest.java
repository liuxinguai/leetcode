package com.github.leetcode.binarytree;

import org.junit.Test;

/**
 *
 */
public class SearchTreeTest {

    private Node<Integer> builderBinaryTree() {
        Node<Integer> node2 = new Node<>(7,new Node<>(6,null,null),new Node<>(8,null,null));
        Node<Integer> node5 = new Node<>(12,new Node<>(11,null,null),new Node<>(13,null,null));
        Node<Integer> head = new Node<>(10,node2,node5);
        return head;
    }

    @Test
    public void testSearch() {
        SearchTree searchTree = new SearchTree();
        assert searchTree.isSearch(builderBinaryTree());
    }

    @Test
    public void testSearch2() {
        SearchTree searchTree = new SearchTree();
        assert searchTree.search(builderBinaryTree());
    }

}
