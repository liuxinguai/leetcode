package com.github.leetcode.week1;

import org.junit.Test;

public class BaseQueueDemo {

    @Test
    public void test() {
        BaseQueue queue = new BaseQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.peek());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
