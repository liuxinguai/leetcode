package com.github.leetcode.week3;

/**
 * 只出现一次的数字 II
 * @author xinguai.liu
 */
public class LeetCode137 {

    public int solute(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num: nums){
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
