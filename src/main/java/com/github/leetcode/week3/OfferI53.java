package com.github.leetcode.week3;

/**
 * @author xinguai.liu
 */
public class OfferI53 {
    
    public int solute(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right - left) / 2 + left;
        while (left <= right) {
            if (nums[mid] == target) {
                int leftIndex = mid - 1;
                int rightIndex = mid + 1;
                while (leftIndex >= left && nums[leftIndex] == target) {
                    leftIndex --;
                }
                while (rightIndex <= right && nums[rightIndex] == target) {
                    rightIndex ++;
                }
                return rightIndex - leftIndex - 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        return 0;
    }
    
}
