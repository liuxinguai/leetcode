package com.github.leetcode.linked;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Stack;

public class TwoLinked<V> {


    private Node<V> head;


    public TwoLinked(V value) {
        this.head = new Node<>(value,null,null);
    }


    public TwoLinked add(V value) {
        Node newNode = new Node(value,null,null);
        Node nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = newNode;
        newNode.prev = nextNode;
        return this;
    }

    public <V> void println() {
        Node printNode = head,prev = head;
        StringBuilder builder = new StringBuilder();
        while (printNode != null) {
            builder.append(printNode.value).append("->");
            prev = printNode;
            printNode = printNode.next;
        }
        builder.delete(builder.length()-2,builder.length()).append("\n");
        while (prev != null) {
            builder.append(prev.value).append("->");
            prev = prev.prev;
        }
        builder.delete(builder.length()-2,builder.length());
        System.out.println(builder);
    }

    public void reverse() {
        while (head != null && head.next != null) {
            Node temp = head.next;
            head.next = head.prev;
            head.prev = temp;
            head = temp;
        }
        if (head != null) {
            head.next = head.prev;
            head.prev = null;
        }
    }

    public void reverse2() {
        Stack<Node<V>> stack = new Stack<>();
        while (head != null) {
            Node<V> node = head;
            head = head.next;
            node.prev = null;
            node.next = null;
            stack.add(node);
        }
        head = stack.pop();
        Node<V> node = head;
        while (!stack.isEmpty()) {
            Node<V> stackNode = stack.pop();
            node.next = stackNode;
            stackNode.prev = node;
            node = node.next;
        }
    }


    @AllArgsConstructor
    static class Node<V> {

        private V value;

        private Node<V> next;

        private Node<V> prev;

    }

}
