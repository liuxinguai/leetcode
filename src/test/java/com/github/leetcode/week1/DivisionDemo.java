package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class DivisionDemo {

    Division division;

    Random random = new Random();

    @Before
    public void init() {
        division = new Division(1);
        for (int i = 0; i < 20; i++) {
            division.add(random.nextInt(20));
        }
        division.println();
    }

    @Test
    public void test() {
        division.division(10).println();
    }
}
