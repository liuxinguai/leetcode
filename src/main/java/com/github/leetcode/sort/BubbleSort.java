package com.github.leetcode.sort;

/**
 * <ul>冒泡排序法：循环选择并比较数组相邻两个元素之间的大小，若当前元素大于下一个相邻元素，则交换相邻位置</ul>
 *  <li>比如：5,4,3,2,1,8,9,10,8</li>
 *  <li>第一次循环：选择并比较数组相邻两个元素之间的大小，当前数组变为：4,3,2,1,5,8,9,8,10</li>
 *  <li>第二次循环：选择并比较数组相邻两个元素之间的大小，当前数组变为：3,2,1,4,5,8,8,9,10</li>
 *  <li>第三次循环：选择并比较数组相邻两个元素之间的大小，当前数组变为：2,1,3,4,5,8,8,9,10</li>
 *  <li>第四次循环：选择并比较数组相邻两个元素之间的大小，当前数组变为：1,2,3,4,5,8,8,9,10</li>
 * @author liuxg
 */
public class BubbleSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr,j , j - 1);
                }
            }
        }
    }

    private void swap(int[] arr, int i ,int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
