package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.Random;

public class BaseTest extends TestCase {

    protected int[] source;

    protected int getRandomFactor() {
        return 20;
    }

    protected int[] gener(int length, int factor, String name) {
        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(factor);
            if (i == 0) {
                System.out.printf("%s[%d", name, arr[i]);
            } else {
                System.out.printf(",%d",arr[i]);
            }
            if (i == length - 1) {
                System.out.println("]");
            }
        }
        return arr;
    }

    @Override
    public void setUp() throws Exception {
        source = new int[20];
        Random random = new Random();
        for (int i = 0; i < source.length; i++) {
            source[i] = random.nextInt(getRandomFactor());
            if (i == 0) {
                System.out.printf("%d",source[i]);
            } else {
                System.out.printf(",%d",source[i]);
            }
        }
        System.out.println();
    }

}
