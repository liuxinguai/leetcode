package com.github.leetcode.week3;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Random;

public class BaseTest extends TestCase {

    protected int[] generateArr(String name, int length, int factor, boolean sort) {
        int[] arr = new int[length];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(factor);
        }
        if (sort) {
            Arrays.sort(arr);
        }
        println(name,arr);
        return arr;
    }

    protected void println(String name, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                System.out.printf("%s[%d",name,arr[i]);
            } else {
                System.out.printf(",%d",arr[i]);
            }
        }
        System.out.println("]");
    }

}
