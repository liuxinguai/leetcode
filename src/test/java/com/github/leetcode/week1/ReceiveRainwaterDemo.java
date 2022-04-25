package com.github.leetcode.week1;

import org.junit.Test;

import java.util.Arrays;

public class ReceiveRainwaterDemo {

    @Test
    public void test() {
        ReceiveRainwater receiveRainwater = new ReceiveRainwater();
        //[0,1,0,2,1,0,1,3,2,1,2,1]
        int water = receiveRainwater.maxWater(Arrays.asList(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
        System.out.println(water);
    }
}
