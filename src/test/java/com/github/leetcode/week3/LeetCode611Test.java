package com.github.leetcode.week3;


public class LeetCode611Test extends BaseTest {

    int[] arr;

    @Override
    public void setUp() throws Exception {
        arr = generateArr("",10,20,false);
    }

    public void testSolute() {
        System.out.println(new LeetCode611().solute(arr));
    }
}