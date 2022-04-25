package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class DeleteLink extends OneNodeOperator {


    public DeleteLink(Integer value) {
        super(value);
    }

    public DeleteLink(Node<Integer> head, Integer size) {
        super(head, size);
    }

    @Override
    public void delete(Integer value) {
        Node<Integer> current = head;
        Node<Integer> prev = null;
        while (current != null) {
            Node<Integer> next = current.next;
            if (current.value.intValue() == value) {
                if (prev != null) {
                    prev.next = current.next;
                }
                if (current == head) {
                    head = next;
                }
                current.next = null;
            } else {
                prev = current;
            }
            current = next;
        }
    }
}
