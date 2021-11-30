package com.github.leetcode.recursion;

import org.junit.Test;

public class TowerOfHanoiTest {

    @Test
    public void test() {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.move("左", "右", "中", 3);
    }
}
