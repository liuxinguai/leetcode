package com.github.leetcode.base;

/**
 * <ul>插入排序法：循环将数组中的元素插入到有序数组的合适位置</ul>
 * @author liuxg
 */
public class InsertSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr, j,j - 1);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
