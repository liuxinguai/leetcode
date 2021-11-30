package com.github.leetcode.recursion;

import org.junit.Test;

public class KnapsackTest {

    @Test
    public void test() {
        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.maxValue(new int[]{10,20,30,40},new int[]{5,7,9,3},50));
    }

}
