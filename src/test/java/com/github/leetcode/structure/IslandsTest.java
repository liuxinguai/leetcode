package com.github.leetcode.structure;

import org.junit.Test;

public class IslandsTest {

    @Test
    public void test() {
        int[][] array = new int[][]{
                {0,1,1,0,1},
                {1,0,1,0,1},
                {1,1,0,1,0}
        };
        System.out.println(new Islands().countLands(array));
    }
}
