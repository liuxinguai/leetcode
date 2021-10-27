package com.github.leetcode.dichotomous;

/**
 * @author liuxg
 */
public class DichotomousFind {

    public boolean exit(int num, int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (array[left] < num && array[right] > num) {
            int mid = (right + left) % 2 == 0 ? (right + left) / 2 : (right + left) / 2 + 1;
            if (array[mid] == num) {
                return true;
            } else if (array[mid] > num) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (array[left] == num || array[right] == num) {
            return true;
        }
        return false;
    }

    /**
     * <ul>局部最小值概念：</ul>
     *  <li>a[0] < a[1] ==> 局部最小值为数组第一位 </li>
     *  <li>a[n-1] < a[n-2] ==> 局部最小值为数组最后一位</li>
     *  <li>i > 0 && i < n-1且a[i-1] > a[i] < a[i + 1] ==>局部最小值为数组数组第i+1位置</li>
     * 已知：数组
     * @param array 数组相邻元素不相等
     * @return 若找到返回局部最小值的下标，若没有找到返回-1
     */
    public int localMinimum(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (array[left] > array[left + 1] && array[right] > array[right - 1]) {
            int mid = (right + left) % 2 == 0 ? (right + left) / 2 : (right + left) / 2 + 1;
            if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]) {
                return mid;
            } else if (array[mid] > array[mid - 1]) {
                right = mid;
            } else if (array[mid] > array[mid + 1]) {
                left = mid;
            }
        }
        if (array[left] < array[left + 1]) {
            return left;
        }
        if (array[right] < array[right - 1]) {
            return right;
        }
        return -1;
    }

}
