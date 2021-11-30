package com.github.leetcode.structure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UnionFindSetTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        UnionFindSet<Integer> unionFindSet = new UnionFindSet<>(list);
        if (!unionFindSet.isSameSet(1,2)) {
            unionFindSet.union(1,2);
        }
        if (!unionFindSet.isSameSet(3,4)) {
            unionFindSet.union(3,4);
        }
        unionFindSet.union(1,3);
        System.out.println(unionFindSet.isSameSet(1,4));
    }

}
