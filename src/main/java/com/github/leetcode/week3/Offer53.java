package com.github.leetcode.week3;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @author xinguai.liu
 */
public class Offer53 {

    public int solute(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left;
    }


}
