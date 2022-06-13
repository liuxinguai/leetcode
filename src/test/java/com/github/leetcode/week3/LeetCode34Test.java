package com.github.leetcode.week3;


import java.util.Random;

public class LeetCode34Test extends BaseTest {

    int[] arr;
    int target;

    @Override
    public void setUp() throws Exception {
        arr = generateArr("",20,20,true);
        target = new Random().nextInt(20);
        System.out.println(target);
    }

    public void testSolute() {
        println("",new LeetCode34().solute(arr, target));
    }
}