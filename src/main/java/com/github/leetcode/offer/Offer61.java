package com.github.leetcode.offer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class Offer61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        boolean flag = true;
        int pre = nums[0], index = pre == 0 ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                index ++;
                continue;
            }
            if (pre == 0) {
                pre = nums[i];
                continue;
            }
            if (nums[i] <= pre) {
                return false;
            }
            int num = nums[i] - pre;
            if (num == 1) {
                pre = nums[i];
            } else {
                if (num - 1 <= index) {
                    pre = nums[i];
                } else {
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        new Offer61().isStraight(new int[] {1,2,3,4,5});
    }

}
