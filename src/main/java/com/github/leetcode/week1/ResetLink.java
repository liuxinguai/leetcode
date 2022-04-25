package com.github.leetcode.week1;


/**
 * @author xinguai.liu
 */
public class ResetLink extends OneNodeOperator {


    public ResetLink(Integer value) {
        super(value);
    }

    public ResetLink(Node<Integer> head, Integer size) {
        super(head,size);
    }

    public ResetLink reset() {
        Node<Integer> prev = null;
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return new ResetLink(prev,size);
    }

    public ResetLink resetLink() {
        return new ResetLink(processor(head),size);
    }

    public Node<Integer> processor(Node<Integer> node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node<Integer> processor = processor(node.next);
        node.next.next = node;
        node.next = null;
        return processor;
    }


}
