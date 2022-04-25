package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

public class ResetPrintLinkDemo {

    private ResetPrintLink printLink;

    @Before
    public void init() {
        printLink = new ResetPrintLink(1);
        for (int i = 2; i < 20; i++) {
            printLink.add(i);
        }
        printLink.println();
    }

    @Test
    public void test() {
        System.out.println(printLink.print());
        System.out.println(printLink.print2());
        printLink.println();
    }

}
