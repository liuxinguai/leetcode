package com.github.leetcode.offer;

/**
 * 删除链表的节点
 * @author xinguai.liu
 */
public class Offer18 {

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null, node = head;
        while (node != null && node.val != val) {
            pre = node;
            node = node.next;
        }
        if (pre == null && node.val == val) {
            head = node.next;
            node.next = null;
        } else if (node.val == val) {
            pre.next = node.next;
            node.next = null;
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
