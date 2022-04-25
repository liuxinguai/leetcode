package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class ReciprocalLink extends OneNodeOperator {


    public ReciprocalLink(Integer value) {
        super(value);
    }

    public ReciprocalLink(Node<Integer> head, Integer size) {
        super(head, size);
    }


    public ReciprocalLink reciprocal(int k) {
        if (k >= size) {
            throw new IllegalArgumentException();
        }
        Node<Integer> node = head;
        Node<Integer> reciprocal = head;
        for (int i = 0; i < k; i++) {
            node = node.next;
        }
        while (node != null) {
            node = node.next;
            reciprocal = reciprocal.next;
        }
        return new ReciprocalLink(reciprocal,k);
    }


}
