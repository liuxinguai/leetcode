package com.github.leetcode.sort;

/**
 * @author liuxg
 */
public class CountSort {

    /**
     * 排序数组，数组中的元素满足如下规则：
     * 当0<=i<arr.length，则：0<=arr[i]<=20;
     * @param arr 数组
     */
    public static void sort(int[] arr) {
        int[] help = new int[100];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            help[index] += 1;
        }
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            for (int j = 0; j < help[i]; j++) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,4,5,6,23,45,67,23,45,68,23,45,68};
        CountSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
