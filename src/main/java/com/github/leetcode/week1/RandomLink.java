package com.github.leetcode.week1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Random;

/**
 * @author xinguai.liu
 */
public class RandomLink implements NodeOperator<Integer> {

    private Random random = new Random();

    private Node<Integer> head;

    private Integer size;

    public RandomLink(Node<Integer> head, Integer size) {
        this.head = head;
        this.size = size;
    }

    public RandomLink(Integer value) {
        this.head = new Node<>(value,null,null);
        size = 1;
    }

    @Override
    public void add(Integer value) {
        Node<Integer> newNode = new Node<>(value, null, null);
        Node<Integer> insert = head;
        while (insert.next != null) {
            insert = insert.next;
        }
        insert.next = newNode;
        size++;
        random();
    }

    protected void random() {
        Node<Integer> current = head;
        while (current != null) {
            int nextInt = random.nextInt(size);
            if (size == 0 || size == 2 || size == 4) {
                current.random = null;
            } else {
                Node<Integer> random = head;
                int index = 0;
                while (index < nextInt && random != null) {
                    index++;
                    random = random.next;
                }
                current.random = random;
            }
            current = current.next;
        }
    }


    @Override
    public void delete(Integer o) {

    }

    @Override
    public void println() {
        StringBuilder builder = new StringBuilder();
        Node<Integer> current = head;
        while (current != null) {
            builder.append("(").append(current.value).append(",")
                    .append(current.random == null ? "NULL" : current.random.value).append(")").append("->");
            current = current.next;
        }
        System.out.println(builder.delete(builder.length()-2,builder.length()));
    }

    public RandomLink copy1() {
        HashMap<Node<Integer>,Node<Integer>> copyMap = new HashMap<>(size);
        Node<Integer> current = head;
        while (current != null) {
            copyMap.put(current,new Node<>(current.value,null,null));
            current = current.next;
        }
        current = head;
        while (current != null) {
            Node<Integer> newNode = copyMap.get(current);
            Node<Integer> next = current.next;
            Node<Integer> random = current.random;
            if (next != null) {
                newNode.next = copyMap.get(next);
            }
            if (random != null) {
                newNode.random = copyMap.get(random);
            }
            current = current.next;
        }
        Node<Integer> newHead = copyMap.get(head);
        copyMap.clear();
        return new RandomLink(newHead,size);
    }

    public RandomLink copy2() {
        //TODO 先copy节点
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> next = current.next;
            Node<Integer> copyNode = new Node<>(current.value,next,null);
            current.next = copyNode;
            current = next;
        }
        current = head;
        Node<Integer> newHead = head.next;
        while (current != null) {
            Node<Integer> copyNode = current.next;
            Node<Integer> next = copyNode.next;
            copyNode.random = current.random;
            current.next = next;
            current = next;
        }
        return new RandomLink(newHead,size);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    class Node<V> {

        V value;

        Node<V> next;

        Node<V> random;
    }
}
