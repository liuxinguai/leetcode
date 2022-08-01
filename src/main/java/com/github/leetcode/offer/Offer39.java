package com.github.leetcode.offer;

import java.util.Arrays;

public class Offer39 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid = (nums.length - 0) / 2  + 0;
        return nums[mid];
    }

    public int majorityElement2(int[] nums) {
        int votes = 0, x = 0;
        for (int num : nums) {
            if (x == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }

}
