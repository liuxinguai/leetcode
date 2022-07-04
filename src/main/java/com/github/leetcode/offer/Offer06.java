package com.github.leetcode.offer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author xinguai.liu
 */
public class Offer06 {


    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

}
