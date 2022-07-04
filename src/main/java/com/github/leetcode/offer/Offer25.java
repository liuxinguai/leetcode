package com.github.leetcode.offer;

/**
 * 合并两个排序的链表
 * @author xinguai.liu
 */
public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = l1.val > l2.val ? l2 : l1, node = null;
        while (l1 != null && l2 != null) {

        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
