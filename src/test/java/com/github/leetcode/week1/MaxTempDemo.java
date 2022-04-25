package com.github.leetcode.week1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaxTempDemo {

    @Test
    public void test() {
        MaxTemp temp = new MaxTemp();
        Random random = new Random();
        List<Integer> records = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            int nextInt = random.nextInt(100);
            records.add(nextInt >= 30 ? nextInt : nextInt + 30);
        }
        System.out.println(records);
        System.out.println(temp.temperature(records));
    }
}
