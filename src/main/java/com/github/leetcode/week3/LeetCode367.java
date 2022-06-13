package com.github.leetcode.week3;

/**
 * @author xinguai.liu
 */
public class LeetCode367 {

    public boolean solute(int num) {
        int left = 0;
        int right = num;
        while (left <= right) {
            int mid = (right -left) / 2 + left;
            int sqt = mid * mid;
            if (sqt == num) {
                return true;
            } else if (sqt > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
