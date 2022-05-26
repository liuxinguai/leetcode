package com.github.leetcode.week2;

import java.util.Arrays;

/**
 * @author xinguai.liu
 */
public class LeetCode455 {

    public int answer(int[] childs, int[] foods) {
        int child = 0;
        int cookie = 0;
        Arrays.sort(childs);
        Arrays.sort(foods);
        while (child < childs.length && cookie < foods.length) {
            if (childs[child] <= foods[cookie]) {
                child ++;
            }
            cookie ++;
        }
        return child;
    }

}
