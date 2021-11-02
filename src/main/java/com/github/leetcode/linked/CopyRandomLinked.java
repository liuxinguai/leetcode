package com.github.leetcode.linked;

import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CopyRandomLinked<V> {


    private Node<V> head;

    private int size = 0;

    private final Random random = new Random();

    public CopyRandomLinked(V value) {
        add(new Node<V>(value,null,null));
    }

    private CopyRandomLinked() {

    }

    public CopyRandomLinked<V> add(V value) {
        add(new Node<V>(value,null,null));
        return this;
    }

    public void random() {
        Node node = head;
        while (node != null) {
            node.random = getRandomNode();
            node = node.next;
        }
    }

    public CopyRandomLinked<V> copy2() {
        Map<Node<V>,Node<V>> nodeMap = new HashMap<>();
        Node<V> node = head;
        while (node != null) {
            Node<V> newNode = new Node<>(node.value, null, null);
            nodeMap.put(node,newNode);
            node = node.next;
        }
        node = head;
        while (node != null) {
            Node<V> newNode = nodeMap.get(node);
            newNode.next = nodeMap.get(node.next);
            newNode.random = nodeMap.get(node.random);
            node = node.next;
        }
        CopyRandomLinked<V> copyRandomLinked = new CopyRandomLinked<>();
        copyRandomLinked.head = nodeMap.get(head);
        nodeMap.clear();
        return copyRandomLinked;
    }


    public CopyRandomLinked<V> copy() {
        Node<V> node = head;
        while (node != null) {
            Node<V> nNode = new Node<>(node.value,null,null);
            Node<V> next = node.next;
            node.next = nNode;
            nNode.next = next;
            node = next;
        }
        node = head;
        while (node != null) {
            Node<V> nNode = node.next;
            //新的random=老节点的.random
            nNode.random = node.random;
            node = nNode.next;
        }
        node = head;
        Node nHead = node.next;
        while (node != null) {
            Node<V> nNode = node.next;
            node.next = nNode.next;
            if (nNode.next != null) {
                nNode.next = nNode.next.next;
            }
            node = node.next;
        }
        CopyRandomLinked<V> copyRandomLinked = new CopyRandomLinked<>();
        copyRandomLinked.head = nHead;
        return copyRandomLinked;
    }


    public void println() {
        Node node = head;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.value).append("(random->");
            if (node.random != null) {
                builder.append(node.random.value);
            } else {
                builder.append("null");
            }
            builder.append(")").append("->");
            node = node.next;
        }
        System.out.println(builder.delete(builder.length()-2,builder.length()));
    }


    private Node getRandomNode() {
        int randomNum = random.nextInt(size);
        int index = 0;
        Node node = head;
        while (index++ <= randomNum && node != null) {
            node = node.next;
        }
        return node;
    }

    private void add(Node<V> node) {
        size ++;
        if (head == null) {
            head = node;
            return;
        }
        Node tailNode = head;
        while (tailNode.next != null) {
            tailNode = tailNode.next;
        }
        tailNode.next = node;
    }


    @AllArgsConstructor
    static class Node<V> {

        V value;

        Node<V> next;

        Node<V> random;

    }

}
