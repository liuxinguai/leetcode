package com.github.leetcode.week5;

/**
 * 判断子序列
 * @author xinguai.liu
 */
public class Leetcode392 {

    public boolean isSubsequence(String s, String t) {
        if ("".equals(s)) {
            return true;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < sChars.length && tIndex < tChars.length) {
            if (sChars[sIndex] == tChars[tIndex]) {
                sIndex ++;
                tIndex ++;
            } else {
                tIndex ++;
            }
        }
        return sIndex == sChars.length;
    }

    public static void main(String[] args) {
        new Leetcode392().isSubsequence("abc","ahbgdc");
    }


}
