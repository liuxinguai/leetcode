package com.github.leetcode.offer;

/**
 * 数组中重复的数字
 * @author xinguai.liu
 */
public class Offer03 {

    public int findRepeatNumber(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        for (int num : nums) {
            if (flag[num]) {
                return num;
            } else {
                flag[num] = true;
            }
        }
        return -1;
    }

}
