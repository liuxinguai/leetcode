package com.github.leetcode.week3;

/**
 * 74. 搜索二维矩阵
 * @author xinguai.liu
 */
public class LeetCode74 {

    public boolean solute(int[][] matrix, int target) {
        int rows = matrix.length - 1, columns = 0;
        while (rows >= 0 && columns < matrix[0].length) {
            int num = matrix[rows][columns];
            if (num == target) {
                return true;
            } else if (num > target) {
                rows--;
            } else {
                columns++;
            }
        }
        return false;
    }

}
