package com.github.leetcode.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class ReceiveRainwater {


    private Stack<Integer> stack = new Stack<>();


    public int maxWater(List<Integer> records) {
        int result = 0;
        for (int i = 0; i < records.size(); i++) {
            Integer hight = records.get(i);
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (records.get(stack.peek()) >= hight.intValue()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && records.get(stack.peek()) < hight.intValue()) {
                    int bottom = stack.peek();
                    stack.pop();
                    if (!stack.empty()) {
                        int h = Math.min(records.get(stack.peek()), hight) - records.get(bottom);
                        int w = i - stack.peek() - 1;
                        result += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }


}
