package com.github.leetcode.week2;


public class LeetCode55Test extends BaseTest {

    @Override
    protected int getRandomFactor() {
        return 5;
    }

    public void testAnswer() {
        System.out.println(new LeetCode55().answer(source));
    }
}