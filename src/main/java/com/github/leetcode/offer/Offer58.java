package com.github.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转单词顺序
 */
public class Offer58 {

    public String reverseWords(String s) {
        if (s == null) {
            return "";
        }
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == 32) {
            left ++;
        }
        while (left <= right && s.charAt(right) == 32) {
            right --;
        }
        StringBuilder word = new StringBuilder();
        Deque<String> deque = new ArrayDeque<>();
        while (left <= right) {
            char charAt = s.charAt(left);
            if (word.length() != 0 && charAt == 32) {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (charAt != 32) {
                word.append(charAt);
            }
            left ++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ",deque);
    }

}
