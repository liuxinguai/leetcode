package com.github.leetcode.week2;

/**
 * @author xinguai.liu
 */
public class LeetCode134 {


    public int solute(int[] gasArr, int[] costArr) {
        int sum = 0;
        for (int i = 0; i < gasArr.length; i++) {
            sum += (gasArr[i] - costArr[i]);
        }
        if (sum < 0) {
            return -1;
        }
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gasArr.length; i++) {
            currentGas = currentGas - costArr[i] + gasArr[i];
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }
        return start;
    }


}
