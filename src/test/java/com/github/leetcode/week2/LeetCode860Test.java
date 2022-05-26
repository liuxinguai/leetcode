package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.Random;

public class LeetCode860Test extends TestCase {

    private int[] source;

    @Override
    public void setUp() throws Exception {
        source = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int nextInt = random.nextInt(20);
            if (nextInt % 3 == 0) {
                source[i] = 5;
            } else if (nextInt % 3 == 1) {
                source[i] = 10;
            } else {
                source[i] = 20;
            }
        }
        for (int i = 0; i < source.length; i++) {
            if (i == 0) {
                System.out.printf("%d",source[i]);
            } else {
                System.out.printf(",%d",source[i]);
            }
        }
        System.out.println();
        source = new int[]{5,10,5,10,5,5,10,20};
    }

    public void testAnswer() {
        System.out.println(new LeetCode860().answer(source));
    }
}