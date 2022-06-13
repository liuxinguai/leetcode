package com.github.leetcode.week3;

/**
 * 丢失的数据
 * @author xinguai.liu
 */
public class LeetCode268 {


    public int solute(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length; i++) {
            miss = miss ^ nums[i] ^ (i + 1);
        }
        return miss;
    }

}
