package com.github.leetcode.week3;

/**
 * 二分查找
 * @author xinguai.liu
 */
public class LeetCode704 {

    public int solute(int[] arr, int target) {
        int left = 0,right = arr.length - 1, mid = left + (right - left) / 2;
        while (left <= right) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                //TODO 左边搜索
                right = mid - 1;
            } else {
                //TODO 右边搜索
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        return -1;
    }

}
