package com.github.leetcode.structure;

import org.junit.Test;

public class KMPTest {

    @Test
    public void test() {
        KMP kmp = new KMP();
        System.out.println(kmp.getIndexOf("liuxg","xg2"));
        System.out.println(kmp.getIndexof("liuxg","xg"));
    }
}
