package com.github.leetcode.week1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class OneNodeOperator implements NodeOperator<Integer> {

    protected Node<Integer> head;

    protected Integer size;

    public OneNodeOperator(Integer value) {
        this.head = new Node<>(value,null);
        size = 1;
    }

    public OneNodeOperator(Node<Integer> head, Integer size) {
        this.head = head;
        this.size = size;
    }

    public static Node<Integer> newNode(Integer value) {
        return new Node<>(value,null);
    }


    @Override
    public void println() {
        StringBuilder builder = new StringBuilder();
        Node<Integer> current = head;
        while (current != null) {
            builder.append(current.value).append("->");
            current = current.next;
        }
        System.out.println(builder.delete(builder.length()-2,builder.length()));
    }

    @Override
    public void add(Integer integer) {
        Node<Integer> newNode = new Node<>(integer,null);
        Node<Integer> tail = head;
        Node<Integer> current = head;
        while (current != null) {
            tail = current;
            current = current.next;
        }
        tail.next = newNode;
        size ++;
    }

    public Node<Integer> addAndReturn(Integer integer) {
        Node<Integer> newNode = new Node<>(integer,null);
        Node<Integer> tail = head;
        Node<Integer> current = head;
        while (current != null) {
            tail = current;
            current = current.next;
        }
        tail.next = newNode;
        size ++;
        return newNode;
    }


    @Override
    public void delete(Integer integer) {
        throw new UnsupportedOperationException();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    static class Node<V> {

        V value;

        Node<V> next;
    }


}
