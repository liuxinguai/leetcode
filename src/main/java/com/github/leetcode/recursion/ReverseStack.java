package com.github.leetcode.recursion;

import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class ReverseStack {


    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int item = processor(stack);
        reverse(stack);
        stack.push(item);
    }


    protected Integer processor(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = processor(stack);
            stack.push(result);
            return last;
        }
    }
}
