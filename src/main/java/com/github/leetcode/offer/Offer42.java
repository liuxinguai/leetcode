package com.github.leetcode.offer;

/**
 * 连续子数组的最大和
 */
public class Offer42 {

    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
