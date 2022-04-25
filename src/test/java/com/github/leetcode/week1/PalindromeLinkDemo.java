package com.github.leetcode.week1;

import org.junit.Before;
import org.junit.Test;

public class PalindromeLinkDemo {
    
    private PalindromeLink link;
    
    @Before
    public void init() {
        link = new PalindromeLink(1);
        link.add(2);
        link.add(3);
        link.add(2);
        link.add(1);
        link.println();
    }
    
    @Test
    public void test() {
        System.out.println(link.isPalind());
        link.println();
    }

}
