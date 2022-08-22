package com.github.leetcode.offer.two;

/**
 * 左旋转字符串
 */
public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        if (s == null || s.equals("") || s.length() < n) {
            return null;
        }
        char[] chars = new char[s.length()];
        int index = n, start = 0;
        while(index < s.length()) {
            chars[start ++] = s.charAt(index ++);
        }
        index = 0;
        while (index < n) {
            chars[start ++] = s.charAt(index ++);
        }
        return new String(chars);
    }

}
