package com.github.leetcode.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author xinguai.liu
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = result.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[right --] = nums[i];
            } else {
                result[left ++] =  nums[i];
            }
        }
        return result;
    }

}
