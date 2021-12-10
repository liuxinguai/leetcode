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
                    cur = cur.right;
                    mostRight.right = null;
                    reversePrintln(cur.left);
                }
            } else {
                cur = cur.right;
            }
        }
        reversePrintln(head);
    }

    protected <V extends Comparable> void reversePrintln(Node<V> cur) {
        cur = reverse(cur);
        Node<V> node = cur;
        while (node != null) {
            System.out.println(node.value);
            node = node.right;
        }
        reverse(cur);
    }

    protected <V extends Comparable> Node<V> reverse(Node<V> cur) {
        Node<V> head = null,right;
        while (cur != null && (right = cur.right) != null) {
            cur.right = right.right;
            right.right = cur;
            cur = cur.right;
            right.right.right = head;
            head = right;
        }
        if (cur != null) {
            cur.right = head;
        }
        return cur;
    }


}
