package com.github.leetcode.week1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WindowDemo {

    @Test
    public void test() {
        Window window = new Window();
        List<Integer> list = Arrays.asList(1,3,-1,-3,5,3,6,7);
        System.out.println(list);
        System.out.println(window.max(list,3));
        Random random = new Random();
        int size = 20;
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(size));
        }
        System.out.println(list);
        System.out.println(window.max(list,3));
    }
}
