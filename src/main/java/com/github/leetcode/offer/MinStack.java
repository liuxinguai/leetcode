package com.github.leetcode.offer;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> xStack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(),x));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int min() {
        return minStack.peek();
    }


}
