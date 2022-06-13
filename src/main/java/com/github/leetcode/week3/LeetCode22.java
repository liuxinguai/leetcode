package com.github.leetcode.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode22 {

    private static final String LEFT = "(";

    private static final String RIGHT = ")";

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        process(n,n,new StringBuilder());
        return result;
    }


    protected void process(int left, int right, StringBuilder stringBuilder) {
        if (left == 0 && right == 0) {
            result.add(stringBuilder.toString());
            return;
        }
        if (left > 0) {
            stringBuilder.append("(");
            process(left - 1,right, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (right > left && right > 0) {
            stringBuilder.append(")");
            process(left,right - 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }



}
