package com.github.leetcode.week2;

/**
 * @author xinguai.liu
 */
public class LeetCode376 {

    public boolean solute(int[] arr) {
        boolean previous = arr[1] > arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            boolean next = arr[i + 1] > arr[i];
            if (previous == next) {
                return false;
            }
            previous = next;
        }
        return true;
    }

}
