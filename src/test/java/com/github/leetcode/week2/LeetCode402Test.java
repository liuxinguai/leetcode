package com.github.leetcode.week2;

import junit.framework.TestCase;

import java.util.Random;

public class LeetCode402Test extends TestCase {

    String word = "";

    @Override
    public void setUp() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            word += random.nextInt(10);
        }
        System.out.println(word);
    }

    public void testSolute() {
        System.out.println(new LeetCode402().solute(word,3));
    }
}