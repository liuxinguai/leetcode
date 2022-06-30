package com.github.leetcode.week5;

/**
 * 最大子数组和
 * @author xinguai.liu
 */
public class Leetcode53 {

//    List<>

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res =  Math.max(res,dp[i]);
        }
        return res;
    }

    public int dfs(int[] nums, int index, int sum) {
        if (nums.length == index) {
            return sum;
        }
        int in ;
        if (sum == Integer.MIN_VALUE) {
            in = dfs(nums,index + 1, nums[index]);
        } else {
            in = dfs(nums, index + 1, sum + nums[index]);
        }
        int no = dfs(nums,index + 1,Integer.MIN_VALUE);
        return Math.max(Math.max(in,no),sum);
    }

}
