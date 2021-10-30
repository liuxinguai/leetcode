package com.github.leetcode.sort;


/**
 * @author liuxg
 */
public class Bucket {

    public static void sort(int[] arr) {
        toSort(arr,0,arr.length-1,maxBits(arr));
    }

    public static void toSort(int[] arr, int L, int R, int digit) {
        int radix = 10,i = 0, j = 0;
        int[] bucket = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigist(arr[i],d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i-1];
            }
            for (i = R; i >= L; i--) {
                j = getDigist(arr[i],d);
                bucket[count[j] - 1] = arr[i];
                count[j] --;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = bucket[j];
            }
        }
    }

    public static int maxBits(int[] arr) {
        int max = arr[0];
        for (int item : arr) {
            max = max < item ? item : max;
        }
        int result = 0;
        while (max != 0) {
            result ++;
            max /= 10;
        }
        return result;
    }

    public static int getDigist(int x, int d) {
        return ((x / ((int) Math.pow(10,d -1))) % 10);
    }


}
