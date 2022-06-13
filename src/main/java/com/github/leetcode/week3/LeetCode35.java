package com.github.leetcode.week3;

/**
 * 搜索插入位置
 * @author xinguai.liu
 */
public class LeetCode35 {

    public int findOrInsert(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = (right - left) / 2 + left;
        while (left <= right) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        return left;
    }

}
