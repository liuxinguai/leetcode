package com.github.leetcode.recursion;

/**
 * @author xinguai.liu
 */
public class CardLine {

    public int win(int[] arr) {
        return Math.max(first(arr,0, arr.length - 1), second(arr,0, arr.length - 1));
    }

    protected int first(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        return Math.max(arr[left] + second(arr,left+1, right),arr[right] + second(arr, left,right-1));
    }

    protected int second(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        return Math.min(first(arr,left + 1, right), first(arr,left,right - 1));
    }

}
