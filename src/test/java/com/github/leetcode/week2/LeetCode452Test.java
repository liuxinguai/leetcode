package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.Random;

public class LeetCode452Test extends TestCase {

    int[][] source = null;

    @Override
    public void setUp() throws Exception {
        source = new int[10][2];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num1 = random.nextInt(50), num2 = random.nextInt(50);
            if (num1 > num2) {
                source[i][0] = num2;
                source[i][1] = num1;
            } else if (num1 < num2) {
                source[i][0] = num1;
                source[i][1] = num2;
            } else {
                source[i][0] = num1;
                source[i][1] = num1 + random.nextInt(5) + 1;
            }
            if (i==0) {
                System.out.printf("[%d,%d]",source[i][0],source[i][1]);
            } else {
                System.out.printf(",[%d,%d]",source[i][0],source[i][1]);
            }
        }
        System.out.println();
    }



    public void testAnswer() {
        System.out.println(new LeetCode452().answer(source));
    }
}