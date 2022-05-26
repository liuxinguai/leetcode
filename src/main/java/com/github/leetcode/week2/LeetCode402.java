package com.github.leetcode.week2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xinguai.liu
 */
public class LeetCode402 {

    public String solute(String word, int k) {
        int length = word.length();
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char charAt = word.charAt(i);
            while (!deque.isEmpty() && k > 0 && charAt < deque.peekLast()) {
                deque.pollLast();
                k --;
            }
            deque.offerLast(charAt);
        }
        for (; k > 0; k --) {
            deque.pollLast();
        }
        boolean leader = true;
        StringBuilder builder = new StringBuilder();
        while (!deque.isEmpty()) {
            Character first = deque.pollFirst();
            if (leader == true && first == '0') {
                continue;
            }
            leader = false;
            builder.append(first);
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }

}
