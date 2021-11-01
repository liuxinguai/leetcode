package com.github.leetcode.linked;

import lombok.AllArgsConstructor;

import java.util.Stack;

public class OneLinked<V> {

    private Node<V> head;

    public OneLinked(V value) {
        head = new Node<>(value,null);
    }

    public OneLinked<V> add(V value) {
        Node newNode = new Node(value,null);
        Node nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = newNode;
        return this;
    }

    public <V> void println() {
        Node printNode = head;
        StringBuilder builder = new StringBuilder();
        while (printNode != null) {
            builder.append(printNode.value).append("->");
            printNode = printNode.next;
        }
        builder.delete(builder.length()-2,builder.length());
        System.out.println(builder);
    }

    public void reverse() {
        Node<V> newHead = null, nextNode;
        while (head != null && (nextNode = head.next) != null) {
            head.next = nextNode.next;
            nextNode.next = head;
            head = head.next;
            nextNode.next.next = newHead;
            newHead = nextNode;
        }
        if (head != null) {
            head.next = newHead;
            newHead = head;
        }
        this.head = newHead;
    }

    public void reverse2() {
        Stack<Node<V>> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        Node<V> node = stack.pop();
        head = node;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            node.next.next = null;
            node = node.next;
        }
    }


    @AllArgsConstructor
    static class Node<V> {

        private V value;

        private Node<V> next;

    }

}
