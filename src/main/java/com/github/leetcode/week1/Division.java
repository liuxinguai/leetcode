package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class Division extends OneNodeOperator {


    public Division(Integer value) {
        super(value);
    }

    public Division(Node<Integer> head, Integer size) {
        super(head, size);
    }


    public Division division(int value) {
        Node<Integer> minNode = new Node<>(Integer.MIN_VALUE,null);
        Node<Integer> prevMinNode = minNode;
        Node<Integer> maxNode = new Node<>(Integer.MAX_VALUE,null);
        Node<Integer> prevMaxNode = maxNode;
        Node<Integer> node = head;
        while (node != null) {
            if (node.value < value) {
                minNode.next = node;
                minNode = minNode.next;
            } else {
                maxNode.next = node;
                maxNode = maxNode.next;
            }
            node = node.next;
        }
        prevMaxNode = prevMaxNode.next;
        prevMinNode = prevMinNode.next;
        minNode.next = prevMaxNode;
        return new Division(prevMinNode,size);
    }


}
