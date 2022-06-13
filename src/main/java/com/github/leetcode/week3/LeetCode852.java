package com.github.leetcode.week3;

/**
 * @author xinguai.liu
 */
public class LeetCode852 {

    public int solute(int[] nums) {
        int left = 1, right = nums.length - 2, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            }
            if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            }
        }
        return left;
    }

}
