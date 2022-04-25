package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class AscMerge extends OneNodeOperator {

    public AscMerge(Integer value) {
        super(value);
    }

    public AscMerge(Node<Integer> head, Integer size) {
        super(head, size);
    }

    @Override
    public void add(Integer integer) {
        Node<Integer> node = head;
        Node<Integer> prev = null;
        while (node != null && node.value < integer) {
            prev = node;
            node = node.next;
        }

        Node<Integer> newNode = newNode(integer);
        if (node != null) {
            newNode.next = node;
            if (prev == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
        } else {
            prev.next = newNode;
        }
    }

    public AscMerge merge(AscMerge merge) {
        Node<Integer> newHead = newNode(Integer.MIN_VALUE);
        Node<Integer> prev = newHead;
        Node<Integer> node1 = this.head;
        Node<Integer> node2 = merge.head;
        while (node1 != null && node2 != null) {
            if (node1.value > node2.value) {
                newHead.next = node2;
                node2 = node2.next;
            } else {
                newHead.next = node1;
                node1 = node1.next;
            }
            newHead = newHead.next;
        }
        if (node1 == null) {
            newHead.next = node2;
        }
        if (node2 == null) {
            newHead.next = node1;
        }
        return new AscMerge(prev.next, merge.size+this.size);
    }


}
