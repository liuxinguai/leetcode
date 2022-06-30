package com.github.leetcode.week5;

/**
 * 斐波那契数
 * @author xinguai.liu
 */
public class Leetcode509 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int dfs(int n) {
        if (n <= 1) {
            return n;
        }
        return dfs(n - 1) + dfs(n - 2);
    }

}
