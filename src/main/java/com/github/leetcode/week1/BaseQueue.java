package com.github.leetcode.week1;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 先进先出
 * @author xinguai.liu
 */
public class BaseQueue {

    private Stack<Integer> start = new Stack<>();

    private Stack<Integer> tail = new Stack<>();

    public void push(Integer value) {
        start.push(value);
    }


    public Integer pop() {
        if (start.isEmpty()) {
            throw new EmptyStackException();
        }
        while (!start.isEmpty()) {
            tail.push(start.pop());
        }
        Integer top = tail.pop();
        while (!tail.isEmpty()) {
            start.push(tail.pop());
        }
        return top;
    }

    public Integer peek() {
        if (start.isEmpty()) {
            throw new EmptyStackException();
        }
        while (!start.isEmpty()) {
            tail.push(start.pop());
        }
        Integer top = tail.peek();
        while (!tail.isEmpty()) {
            start.push(tail.pop());
        }
        return top;
    }

    public boolean empty() {
        return start.isEmpty();
    }

}
