package com.github.leetcode.other;

import org.junit.Test;

public class PrefixTreeTest {

    private final PrefixTree prefixTree = new PrefixTree();


    @Test
    public void test() {
        prefixTree.insert("liuxg");
        prefixTree.insert("liuxgcf");
        prefixTree.insert("xg");
        System.out.println(prefixTree.search("xg"));
        System.out.println(prefixTree.searchPrex("liu"));
        prefixTree.delete("liuxgcf");
        System.out.println(prefixTree.searchPrex("liuxg"));
    }

}
