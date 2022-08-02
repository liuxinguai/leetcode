package com.github.leetcode.offer;

public class Offer57 {

    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left ++;
            } else if (sum > target){
                right --;
            } else {
                return new int[] {left, right};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Offer57 offer57 = new Offer57();
        offer57.twoSum(new int[]{2,7,11,15},9);
    }

}
