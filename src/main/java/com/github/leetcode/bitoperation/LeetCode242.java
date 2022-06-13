package com.github.leetcode.bitoperation;

/**
 * @author xinguai.liu
 */
public class LeetCode242 {

    public boolean solute(String str1, String str2) {
        final char[] chars1 = str1.toCharArray();
        final char[] chars2 = str2.toCharArray();
        if (chars1.length != chars2.length) {
            return false;
        }
        int[] tab = new int[26];
        for (int i = 0; i < chars1.length; i++) {
            tab[chars1[i] - 'a'] ++;
        }
        for (int i = 0; i < chars2.length; i++) {
            tab[chars2[i] - 'a'] --;
            if (tab[chars2[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

}
