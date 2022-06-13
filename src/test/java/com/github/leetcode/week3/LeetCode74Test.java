package com.github.leetcode.week3;


import java.util.Arrays;
import java.util.Random;

public class LeetCode74Test extends BaseTest {

    int[][] matrix;

    int target;

    @Override
    public void setUp() throws Exception {
        matrix = new int[4][5];
        Random random = new Random();
        int[] sorts = new int[20];
        for (int i = 0; i < 20; i++) {
            sorts[i] = random.nextInt(50);
        }
        Arrays.sort(sorts);
        int index = 0;
        System.out.println("[");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = sorts[index++];
                if (j == 0) {
                    System.out.printf("\t[%d",matrix[i][j]);
                } else {
                    System.out.printf(",%d",matrix[i][j]);
                }
            }
            System.out.println("]");
        }
        System.out.println("]");
        target = random.nextInt(50);
        System.out.println(target);
    }

    public void testSolute() {
        System.out.println(new LeetCode74().solute(matrix,target));
    }
}