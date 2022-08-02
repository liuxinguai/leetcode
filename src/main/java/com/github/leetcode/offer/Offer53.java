package com.github.leetcode.offer;

/**
 * 在排序数组中查找数字 I
 */
public class Offer53 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1,count = 0;
        while(left <= right) {
            if(nums[left] == target) {
                left++;
                count++;
            } else if(nums[right] == target){
                right--;
                count++;
            } else {
                left++;
                right--;
            }
        }
        return count;
    }
}
