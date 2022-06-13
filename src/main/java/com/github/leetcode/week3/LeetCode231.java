package com.github.leetcode.week3;

/**
 * 2的幂次
 * @author xinguai.liu
 */
public class LeetCode231 {

    public boolean solute(int num) {
        return  (num > 0) && (num & (num - 1 )) == 0;
    }
}
