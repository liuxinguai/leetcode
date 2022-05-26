package com.github.leetcode.week2;


public class LeetCode376Test extends BaseTest {

    @Override
    protected int getRandomFactor() {
        return 10;
    }

    public void testSolute() {
        System.out.println(new LeetCode376().solute(source));
    }
}