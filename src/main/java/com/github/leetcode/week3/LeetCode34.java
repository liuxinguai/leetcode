package com.github.leetcode.week3;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * @author xinguai.liu
 */
public class LeetCode34 {

    public int[] solute(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = (right - left) / 2 + left;
        while (left <= right) {
            if (arr[mid] == target) {
                int leftIndex = mid - 1;
                int rightIndex = mid + 1;
                while (leftIndex >= left && arr[leftIndex] == target) {
                    leftIndex --;
                }
                while (rightIndex <= right && arr[rightIndex] == target) {
                    rightIndex ++;
                }
                return new int[]{leftIndex + 1, rightIndex - 1};
            } else if (arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            mid = (right - left) / 2 + left;
        }
        return new int[]{-1,-1};
    }

}
