package com.github.leetcode.linked;

import lombok.AllArgsConstructor;

public class TwoLinkedIntersect<V> {



    public Node<V> intersect(Node<V> head1, Node<V> head2) {
        if (head1 == head2) {
            return head1;
        }
        Node<V> loop1 = isLoop(head1);
        Node<V> loop2 = isLoop(head2);

        if (loop1 != null && loop2 != null) {
            if (loop1 == loop2) {
                return loop1;
            }
            Node<V> fastNode = loop1.next.next,slowNode = loop2.next;
            while (fastNode != loop1) {
                if (fastNode == slowNode || fastNode == loop2 || slowNode == loop1) {
                    return loop1;
                }
                slowNode = slowNode.next;
                fastNode = fastNode.next.next;
            }
        } else if (loop1 == null && loop2 == null){
            int nodeNum = 0;
            loop1 = head1;
            loop2 = head2;
            while (loop1 != null) {
                loop1 = loop1.next;
                nodeNum++;
            }
            while (loop2 != null) {
                loop2 = loop2.next;
                nodeNum --;
            }
            if (nodeNum > 0) {
                loop1 = head1;
                while (nodeNum > 0) {
                    loop1 = loop1.next;
                    nodeNum --;
                }
                if (loop1 == head2) {
                    return head2;
                }
            } else if (nodeNum < 0){
                loop2 = head2;
                while (nodeNum < 0) {
                    loop2 = loop2.next;
                    nodeNum ++;
                }
                if (loop2 == head1) {
                    return head1;
                }
            }
        }
        return null;

    }


    protected Node<V> isLoop(Node<V> head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node<V> fastNode = head, slowNode = head;
        while (slowNode.next != null && fastNode.next.next != null) {
            if (slowNode == fastNode) {
                break;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        fastNode = head;
        if (slowNode == fastNode) {
            if (slowNode == head) {
                return head;
            }
            while (slowNode != fastNode) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            return slowNode;
        }
        return null;
    }



    @AllArgsConstructor
    static class Node<V> {

        private V value;

        private Node<V> next;
    }

}
