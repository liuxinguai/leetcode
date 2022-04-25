package com.github.leetcode.week1;

import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class MinStack {

    private Stack<Integer> stack = new Stack();

    private Stack<Integer> minStack = new Stack<>();

    public void push(Integer value) {
        stack.push(value);
        if (minStack.isEmpty() || minStack.peek() >= value) {
            minStack.push(value);
        }
    }

    public Integer pop() {
        Integer peek = stack.peek();
        if (minStack.peek() == peek.intValue()) {
            minStack.pop();
        }
        return stack.pop();
    }

    public Integer getMin(){
        return minStack.peek();
    }

    public Integer top() {
        return stack.peek();
    }

}
