package com.github.leetcode.offer;

/**
 * 圆圈中最后剩下的数字
 */
public class Offer62 {


    public int lastRemaining(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

}
