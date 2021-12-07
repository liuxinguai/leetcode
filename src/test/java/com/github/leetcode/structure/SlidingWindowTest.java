package com.github.leetcode.structure;

import org.junit.Test;


public class SlidingWindowTest {

    @Test
    public void test() {
        int[] array = new int[] {4,3,5,4,3,3,6,7};
        SlidingWindow slidingWindow = new SlidingWindow(array);
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            slidingWindow.rightMove();
            index ++;
            if (index >= 3) {
                slidingWindow.leftMove();
                System.out.println(slidingWindow.max());
            }
        }
    }
}
