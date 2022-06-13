package com.github.leetcode.week3;

/**
 * 位 1 的个数
 * @author xinguai.liu
 */
public class LeetCode191 {

    public int solute(int num) {
        int ret = 0;
        while (num != 0) {
            num &= (num - 1);
            ret ++;
        }
        return ret;
    }
}
