package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.Random;

public class LeetCode455Test extends TestCase {

    private int[] childs;

    private int[] foods;

    @Override
    public void setUp() throws Exception {
        Random random = new Random();
        childs = new int[20];
        foods = new int[20];
        for (int i = 0; i < 20; i++) {
            childs[i] = random.nextInt(20);
            foods[i] = random.nextInt(20);
        }
        println(childs);
        println(foods);
    }

    public void testAnswer() {
        System.out.println(new LeetCode455().answer(childs,foods));
    }

    private void println(int[] result) {
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                System.out.printf("%d",result[i]);
            } else {
                System.out.printf(",%d",result[i]);
            }
        }
        System.out.println();
    }

}