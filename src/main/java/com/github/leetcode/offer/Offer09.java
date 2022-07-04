package com.github.leetcode.offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author xinguai.liu
 */
public class Offer09 {

    class CQueue {

        Stack<Integer> head = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            Stack<Integer> helper = new Stack<>();
            while(head.size() > 0) {
                helper.push(head.pop());
            }
            head.push(value);
            while (helper.size() > 0) {
                head.push(helper.pop());
            }
        }

        public int deleteHead() {
            return head.size() > 0 ? head.pop() : -1;
        }
    }

}
