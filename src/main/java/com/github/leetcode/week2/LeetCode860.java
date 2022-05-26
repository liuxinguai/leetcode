package com.github.leetcode.week2;

/**
 * @author xinguai.liu
 */
public class LeetCode860 {

    public boolean answer(int[] arr) {
        int five = 0, ten = five;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                five ++;
            } else if (arr[i] == 10) {
                if (five > 0) {
                    five --;
                    ten ++;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    five --;
                    ten --;
                } else if (ten < 0 && five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
         }
        return true;
    }

}
