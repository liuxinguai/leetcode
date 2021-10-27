package com.github.leetcode.base;

/**
 * <ul> 选择排序法：每次循环选择出数组(踢出掉上次循环所选择出来的最小数)中的最小数并放入开始排好序数组的末尾<ul/>
 *  <li>比如：5,4,3,2,1,8,9,10,8</li>
 *  <li>第一次循环：选择出来的最小数是：1,下标是4,当前排好序的数组末尾是：0，对调两者位置，当前数组变为：1,4,3,2,5,8,9,10,8</li>
 *  <li>第二次循环：选择出来的最小数是：2,下标是1,当前排好序的数组末尾是：1，对调两者位置，当前数组变为：1,2,3,4,5,8,9,10,8</li>
 *
 *
 *
 * @author liuxg
 */
public class SectionSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
