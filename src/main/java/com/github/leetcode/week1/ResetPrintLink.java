package com.github.leetcode.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class ResetPrintLink extends ResetLink {

    public ResetPrintLink(Integer value) {
        super(value);
    }

    public List<Integer> print() {
        List<Integer> result = new ArrayList<>(size);
        Node<Integer> node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.value);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public List<Integer> print2() {
        ResetLink reset = reset();
        head = reset.head;
        Node<Integer> current = head;
        List<Integer> result = new ArrayList<>(size);
        while (current != null) {
            result.add(current.value);
            current = current.next;
        }
        reset = reset();
        head = reset.head;
        return result;
    }

}
