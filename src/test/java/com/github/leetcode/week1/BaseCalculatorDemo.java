package com.github.leetcode.week1;

import org.junit.Test;

public class BaseCalculatorDemo {

    @Test
    public void test() {
        BaseCalculator baseCalculator = new BaseCalculator();
        System.out.println(baseCalculator.calc("2 + 3 * ( 3 * (2 + 2))"));
    }
}
