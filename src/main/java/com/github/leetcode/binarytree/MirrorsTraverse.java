package com.github.leetcode.binarytree;

/**
 * @author xinguai.liu
 */
public class MirrorsTraverse {


    public <V extends Comparable> void traverse(Node<V> head) {
        Node<V> cur = head;
        while (cur != null) {
            Node<V> left = cur.left;
            if (left != null) {
                Node<V> mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = left;
                } else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            } else {
                cur = cur.right;
            }
        }
    }

    public <V extends Comparable> void preorder(Node<V> head) {
        if (head == null) {
            return;
        }
        Node<V> cur = head;
        while (cur != null) {
            Node<V> left = cur.left;
            if (left != null) {
                Node<V> mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                } else {
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }

    public <V extends Comparable> void middleorder(Node<V> head) {
        if (head == null) {
            return;
        }
        Node<V> cur = head;
        while (cur != null) {
            Node<V> left = cur.left;
            if (left != null) {
                Node<V> mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.value);
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }


    public <V extends Comparable> void postorder(Node<V> head) {
        if (head == null) {
            return;
        }
        Node<V> cur = head;
        while (cur != null) {
            Node<V> left = cur.left;
            if (left != null) {
                Node<V> mostRight = left;
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                } else {
                    System.out.println(cur.value);
                    cur = cur.right;
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
                cur = cur.right;
            }
        }
    }


}
