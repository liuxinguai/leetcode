package com.github.leetcode.structure;

import org.junit.Test;

public class MonotoneStackTest {

    @Test
    public void test() {
        int[] array = new int[] {5,5,4,4,3,8,8,9,7,6,5,2,1};
        MonotoneStack monotoneStack = new MonotoneStack(array);
        for (int i = 0; i < array.length; i++) {
            monotoneStack.add(i);
        }
        monotoneStack.printlnResult();
    }
}
