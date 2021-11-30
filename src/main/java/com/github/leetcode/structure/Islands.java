package com.github.leetcode.structure;

/**
 * @author xinguai.liu
 */
public class Islands {


    public int countLands(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count ++;
                    infect(matrix,i,j);
                }
            }
        }
        return count;
    }

    protected void infect(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] == 0 || matrix[x][y] == 2) {
            return;
        }
        matrix[x][y] = 2;
        infect(matrix,x - 1, y);
        infect(matrix, x + 1, y);
        infect(matrix, x, y + 1);
        infect(matrix, x, y - 1);
    }

}
