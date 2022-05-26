package com.github.leetcode.week2;


public class LeetCode134Test extends BaseTest {

    int[] gas;

    int[] cost;


    @Override
    public void setUp() throws Exception {
        gas = gener(10,30, "gas");
        Thread.sleep(200);
        cost = gener(10,30, "cost");
    }

    public void testSolute() {
        System.out.println(new LeetCode134().solute(gas,cost));
        gas = new int[]{1,2,3,4,5};
        cost = new int[]{3,4,5,1,2};
        System.out.println(new LeetCode134().solute(gas,cost));
    }
}