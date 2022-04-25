package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class OddEvenLinked extends OneNodeOperator {

    public OddEvenLinked(Integer value) {
        super(value);
    }

    public void parse() {
        if (size <= 2) {
            return;
        }
        Node<Integer> oddNode = head;
        Node<Integer> evenNode = oddNode.next;
        Node<Integer> evenNodeStart = evenNode;
        while (evenNode != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            if (oddNode != null) {
                evenNode.next = oddNode.next;
            }
            evenNode = evenNode.next;
        }
        if (oddNode != null) {
            oddNode.next = evenNodeStart;
        } else {
            oddNode = head;
            while (oddNode.next != null) {
                oddNode = oddNode.next;
            }
            oddNode.next = evenNodeStart;
        }

    }

}
