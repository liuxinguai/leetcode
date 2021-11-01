package com.github.leetcode.linked;

import lombok.AllArgsConstructor;

import java.util.Stack;

public class PalindromeLinked<V> {


    private Node<V> head;

    public PalindromeLinked(V value) {
        this.head = new Node<>(value,null);
    }



    public PalindromeLinked<V> add(V value) {
        Node<V> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node<>(value,null);
        return this;
    }


    public void println() {
        Node<V> tail = head;
        StringBuilder builder = new StringBuilder();
        while (tail != null) {
            builder.append(tail.value).append("->");
            tail = tail.next;
        }
        builder.delete(builder.length() - 2,builder.length());
        System.out.println(builder);
    }

    public boolean isPalindrome2() {
        Stack<Node<V>> stack = new Stack<>();
        Node<V> tail = head;
        while (tail != null) {
            stack.add(tail);
            tail = tail.next;
        }
        tail = head;
        while (!stack.isEmpty()) {
            Node<V> pop = stack.pop();
            if (pop.value != tail.value) {
                return false;
            }
            tail = tail.next;
        }
        return true;
    }

    public boolean isPalindrome() {
        Stack<Node<V>> stack = new Stack<>();
        Node<V> fastNode = head;
        Node<V> slowNode = head;
        while (slowNode.next != null && (fastNode.next != null && fastNode.next.next != null)) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        if (fastNode.next == null) {
            while (slowNode != null) {
                stack.add(slowNode);
                slowNode = slowNode.next;
            }
        } else if (fastNode.next != null) {
            while (slowNode.next != null) {
                stack.add(slowNode.next);
                slowNode = slowNode.next;
            }
        }
        fastNode = head;
        while (!stack.isEmpty()) {
            if (stack.pop().value != fastNode.value) {
                return false;
            }
            fastNode = fastNode.next;
        }
        return true;
    }


    @AllArgsConstructor
    class Node<V> {

        private V value;

        private Node<V> next;


    }

}
