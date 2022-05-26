package com.github.leetcode.week2;


import java.util.Random;

public class LeetCode15Test extends BaseTest {


    protected int[] source;

    protected int getRandomFactor() {
        return 20;
    }

    @Override
    public void setUp() throws Exception {
        source = new int[20];
        Random random = new Random();
        for (int i = 0; i < source.length; i++) {
            source[i] = random.nextInt(getRandomFactor());
            if (source[i] % 5 == 0) {
                source[i] = source[i] * -1;
            }
            if (i == 0) {
                System.out.printf("%d",source[i]);
            } else {
                System.out.printf(",%d",source[i]);
            }
        }
        System.out.println();
    }


    public void testSolute() {
        System.out.println(new LeetCode15().solute(source));
    }
}