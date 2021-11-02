package com.github.leetcode.linked;

import lombok.AllArgsConstructor;

/**
 * @author liuxg
 */
public class PatitionLinked<V extends Comparable> {


    private Node<V> head;

    private int size = 0;

    public PatitionLinked(V value) {
        head = new Node<>(value,null);
        size ++;
    }

    public PatitionLinked<V> add(V value) {
        Node newNode = new Node(value,null);
        Node nextNode = head;
        while (nextNode.next != null) {
            nextNode = nextNode.next;
        }
        nextNode.next = newNode;
        size ++;
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

    /**
     * 将链表拆分成三个区域，小于value值的放入链表的左边，等于value值的放入链表的中间，大于value值的放入链表的右边
     * @param value
     */
    public void sort2(V value) {
        Node[] array = new Node[size];
        int index = 0;
        while (head != null) {
            Node node = head;
            head = head.next;
            array[index++] = node;
            node.next = null;
        }
        partition(array,value);
        Node node = array[0];
        head = node;
        for (int i = 1; i < array.length; i++) {
            node.next = array[i];
            node = node.next;
        }
    }

    /**
     * 将链表拆分成三个区域，小于value值的放入链表的左边，等于value值的放入链表的中间，大于value值的放入链表的右边
     * @param value
     */
    public void sort(V value) {
        Node<V> lessStart = null, lessEnd = null, equalsStart = null, equalsEnd = null, moreStart = null, moreEnd = null;
        while (head != null) {
            Node node = head;
            head = head.next;
            node.next = null;
            if (node.value.compareTo(value) == 0) {
                if (equalsStart == null) {
                    equalsEnd = equalsStart = node;
                } else {
                    equalsEnd.next = node;
                    equalsEnd = equalsEnd.next;
                }
            } else if (node.value.compareTo(value) > 0) {
                if (moreStart == null) {
                    moreEnd = moreStart = node;
                } else {
                    moreEnd.next = node;
                    moreEnd = moreEnd.next;
                }
            } else {
                if (lessStart == null) {
                    lessEnd = lessStart = node;
                } else {
                    lessEnd.next = node;
                    lessEnd = lessEnd.next;
                }
            }
        }
        if (lessStart != null) {
            head = lessStart;
            if (equalsStart != null && moreStart != null) {
                lessEnd.next = equalsStart;
                equalsEnd.next = moreStart;
            } else if (equalsStart == null && moreStart != null) {
                lessEnd.next = moreStart;
            }
        } else if (equalsStart != null) {
            head = equalsStart;
            if (moreStart != null) {
                equalsEnd.next = moreStart;
            }
        } else {
            head = moreStart;
        }
    }

    private void partition(Node[] nodes,V value) {
        int left = -1, right = nodes.length, index = 0;
        while (index < right) {
            if (nodes[index].value.compareTo(value) == 0) {
                index ++;
            } else if (nodes[index].value.compareTo(value) > 0) {
                swap(nodes,--right,index);
            } else {
                swap(nodes,++left,index++);
            }
        }
    }

    private void swap(Node[] nodes, int x, int y) {
        Node temp = nodes[x];
        nodes[x] = nodes[y];
        nodes[y] = temp;
    }


    @AllArgsConstructor
    static class Node<V extends Comparable> {

        private V value;

        private Node<V> next;

    }

}
