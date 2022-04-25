package com.github.leetcode.week1;

/**
 * @author xinguai.liu
 */
public class LoopLink extends OneNodeOperator {

    public LoopLink(Integer value) {
        super(value);
    }

    public LoopLink(Node<Integer> head, Integer size) {
        super(head, size);
    }

    public Node loop() {
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                fast = head;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
