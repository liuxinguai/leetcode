package com.github.leetcode.week1;

import org.junit.Test;

public class MinStackDemo {

    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(2);
        stack.push(1);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }

}
