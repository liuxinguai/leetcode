package com.github.leetcode.offer.two;

import java.util.Arrays;

/**
 * 0～n-1中缺失的数字
 */
public class Offer53 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

}
