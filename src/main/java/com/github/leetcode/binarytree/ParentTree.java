package com.github.leetcode.binarytree;

public class ParentTree {


    protected <V extends Comparable> Node<V> processor(Node<V> head, Node<V> node1, Node<V> node2) {
        if (head == null || head == node1 || head == node2) {
            return head;
        }
        Node<V> left = processor(head.left, node1, node2);
        Node<V> right = processor(head.right,node1,node2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

}
