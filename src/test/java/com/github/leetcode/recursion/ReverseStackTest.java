package com.github.leetcode.recursion;

import org.junit.Test;

import java.util.Stack;

public class ReverseStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        ReverseStack reverseStack = new ReverseStack();
        reverseStack.reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
