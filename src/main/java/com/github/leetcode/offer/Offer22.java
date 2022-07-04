package com.github.leetcode.offer;

import java.util.Stack;

/**
 * 链表中倒数第k个节点
 * @author xinguai.liu
 */
public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
