package com.github.leetcode.bitoperation;

import org.junit.Test;

public class XOROperationTest {

    private final XOROperation xorOperation = new XOROperation();

    @Test
    public void testFindOdd() {
        System.out.println(xorOperation.findOdd(new int[]{1,2,1,2,2,2,2}));
    }

    @Test
    public void testFindTwoOdd() {
        int[] twoOdd = xorOperation.findTwoOdd(new int[]{1, 2, 1, 2, 2, 2, 2, 3, 3, 3});
        System.out.println(twoOdd[0]+","+twoOdd[1]);
    }

    @Test
    public void testFindEven() {
        System.out.println(xorOperation.findEven(new int[]{1, 2, 1, 2, 2, 2, 2}));
    }

}
