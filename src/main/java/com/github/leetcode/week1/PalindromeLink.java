package com.github.leetcode.week1;

import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class PalindromeLink extends OneNodeOperator{

    public PalindromeLink(Integer value) {
        super(value);
    }

    public PalindromeLink(Node<Integer> head, Integer size) {
        super(head, size);
    }

    public boolean isPalind() {
        Stack<Integer> stack = new Stack<>();
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null && fast.next != null) {
            stack.push(slow.value);
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null && !stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop.intValue() != slow.value) {
                return false;
            }
            slow = slow.next;
        }
        return slow == null && stack.isEmpty();
    }

}
