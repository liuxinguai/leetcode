package com.github.leetcode.hash;

import org.junit.Test;

public class RandomPoolTest {


    @Test
    public void test() {
        RandomPool randomPool = new RandomPool();
        randomPool.insert("liuxg");
        randomPool.insert("liuxinguai");
        randomPool.insert("xinguai.liu");
        randomPool.insert("lxg");
        randomPool.insert("liu.xg");
        for (int i = 0; i < 5; i++) {
            System.out.println(randomPool.getRandom());
        }
        System.out.println("delete : "+randomPool.delete());
    }
}
