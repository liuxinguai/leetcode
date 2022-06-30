package com.github.leetcode.week5;

/**
 * @author xinguai.liu
 */
public class LeetcodeLcs01 {

    int leastMinutes(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) dp[i] = dp[(i + 1) / 2] + 1;
        return dp[n];
    }

}
