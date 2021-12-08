package com.github.leetcode.structure;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class MonotoneStack {

    private final Stack<Node> stack = new Stack<>();

    private final int[] array;

    private List<NearMaxNumber> result = new ArrayList<>();

    public MonotoneStack(int[] array) {
        this.array = array;
    }

    public void add(int index) {
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (array[node.value] == array[index]) {
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(index,null);
                return;
            } else if (array[node.value] < array[index]) {
                stack.pop();
                Node left = null;
                if (!stack.isEmpty()) {
                    left = stack.peek();
                    while (left.next != null) {
                        left = left.next;
                    }
                }
                while (node != null) {
                    if (left != null) {
                        result.add(new NearMaxNumber(left.value, node.value, index));
                    } else {
                        result.add(new NearMaxNumber(-1, node.value, index));
                    }
                    node = node.next;
                }
            } else {
                break;
            }
        }
        stack.push(new Node(index,null));
    }

    public void printlnResult() {
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            Node left = null;
            if (!stack.isEmpty()) {
                left = stack.peek();
                while (left.next != null) {
                    left = left.next;
                }
            }
            while (node != null) {
                if (left != null) {
                    result.add(new NearMaxNumber(left.value, node.value, -1));
                } else {
                    result.add(new NearMaxNumber(-1, node.value, -1));
                }
                node = node.next;
            }
        }
        StringBuilder builder = new StringBuilder();
        result.forEach(maxNumber -> {
            builder.append("left : ").append("[").append(maxNumber.left).append(" : ").append(maxNumber.left != -1 ? array[maxNumber.left] : 0).append("],");
            builder.append("value : ").append("[").append(maxNumber.value).append(" : ").append(array[maxNumber.value]).append("],");
            builder.append("right : ").append("[").append(maxNumber.right).append(" : ").append(maxNumber.right != -1 ? array[maxNumber.right] : 0).append("]\r\n");
        });
        System.out.println(builder);
    }

    @AllArgsConstructor
    @ToString
    class NearMaxNumber {

        private int left;

        private int value;

        private int right;

    }

    @AllArgsConstructor
    @ToString
    class Node {

        private int value;

        private Node next;
    }
}
