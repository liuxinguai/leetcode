package com.github.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class Offer50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char at = s.charAt(i);
            map.put(at, map.getOrDefault(at,0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

}
