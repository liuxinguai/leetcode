package com.github.leetcode.week1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xinguai.liu
 */
public class ParenthesisMatch {

    public static final char PARENTHESIS_RIGHT = ')';
    public static final char PARENTHESIS_LEFT = '(';

    public static final char BRACES_RIGHT = ']';
    public static final char BRACES_LEFT = '[';

    public static final char SQUARE_RIGHT = '}';
    public static final char SQUARE_LEFT = '{';

    private static final Map<Character,Character> base = new HashMap<>(3);

    static {
        base.put(PARENTHESIS_LEFT,PARENTHESIS_RIGHT);
        base.put(BRACES_LEFT,BRACES_RIGHT);
        base.put(SQUARE_LEFT,SQUARE_RIGHT);
    }

    private Stack<Character> stack = new Stack<>();

    private List<Character> record = new ArrayList<>();

    public void add(Character value) {
        if (base.containsKey(value) || base.containsValue(value)) {
            record.add(value);
            if (base.containsKey(value)) {
                stack.push(value);
            } else {
               if (!stack.isEmpty()) {
                   Character peek = stack.peek();
                   if (base.get(peek).charValue() == value.charValue()) {
                       stack.pop();
                   }
               }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public boolean isVail() {
        return stack.isEmpty();
    }

    public String string() {
        return record.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public void clear() {
        record.clear();
        stack.clear();
    }

}
