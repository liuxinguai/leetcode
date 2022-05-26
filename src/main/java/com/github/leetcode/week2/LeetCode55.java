package com.github.leetcode.week2;

/**
 * @author xinguai.liu
 */
public class LeetCode55 {

    public boolean answer(int[] source) {
        int[] jump = new int[source.length];
        for (int i = 0; i < jump.length; i++) {
            jump[i] = i + source[i];
        }

        int index = 0;
        int maxJump = source[index];
        while (index < source.length && index <= maxJump) {
            if (jump[index] > maxJump) {
                maxJump = jump[index];
            }
            index ++;
        }
        return index > source.length - 1 ? true : false;
    }


}
