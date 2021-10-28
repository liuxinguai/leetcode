package com.github.leetcode.sort;

import java.util.Random;

/**
 * @author liuxg
 */
public class QuickSort {


    public void sort(int[] arr) {
        processor(arr,0, arr.length-1);
    }

    protected void processor(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int)Math.random() * (right - left +1),right);
            int[] partition = partition(arr, left, right);
            processor(arr,left,partition[0] -1);
            processor(arr,partition[1] + 1,right);
        }
    }

    protected int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr,++less,left++);
            } else if (arr[left] > arr[right]) {
                swap(arr,--more,left);
            } else {
                left ++;
            }
        }
        swap(arr,more,right);
        return new int[] {less + 1, more};
    }


    /**
     * 将一个数组按照如下规则排序：
     *      将大于num的数放置到数组的右侧
     *      将等于num的数放置到数组的中间
     *      将小于num的数放置到数组的左侧
     * 具体做法：
     *      准备三个变量：
     *          一个变量left表示：小于num的最大边界
     *          一个变量right表示：大于num的最小边界
     *          一个变量index表示：当前数组的下标
     *      当数组中当前元素 arr[index] > num ==> 交换当前下标数组的值为上一个arr[left],left++,index++
     *      当数组中当前元素 arr[index] = num ==> index++
     *      当数组中当前元素 arr[index] < num ==> 交换当前下标数组的值为上一个arr[--right]
     *
     * @param arr 数组
     * @param num 某一个数
     */
    protected void partition(int[] arr, int num) {
        int left = 0, right = arr.length, index = 0;
        while (index < right) {
            if (arr[index] < num) {
                swap(arr,left++,index);
                index ++;
            } else if (arr[index] > num) {
                swap(arr,index,--right);
            } else {
                index ++;
            }
        }
    }

    private void swap(int[] arr, int i ,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[] {3,4,5,1,4,5,6,7,8,9,1,2,3,4,6,9,10};
        quickSort.partition(arr,8);
        for (int curr : arr) {
            System.out.println(curr);
        }
        quickSort.sort(arr);
        for (int curr : arr) {
            System.out.println(curr);
        }
    }



}
