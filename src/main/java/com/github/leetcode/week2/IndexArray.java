package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class IndexArray {

    public List<Integer> index(List<Integer> data) {
        List<Integer> result = new ArrayList<>(2);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < data.size(); i++) {
            boolean sortArr = generSortArr(stack, i, data);
            if (sortArr) {
                int index = 0;
                Integer tail = stack.peek();
                while (!stack.isEmpty()) {
                    index ++;
                    stack.pop();
                }
                if (index == 2) {
                    result = new ArrayList<>();
                    result.add(tail);
                    result.add(index);
                    break;
                } else {
                    if (result.isEmpty()) {
                        result.add(tail);
                        result.add(index);
                    } else {
                        if (result.get(1) > index) {
                            result.set(0,tail);
                            result.set(1,index);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            if (stack.isEmpty()) {
                result.add(-1);
                result.add(-1);
            } else {
                int tail = stack.peek();
                int index = 0;
                while (!stack.isEmpty()) {
                    index ++;
                    stack.pop();
                }
                result.add(tail);
                result.add(index);
            }
        }
        Integer tail = result.get(0);
        Integer num = result.get(1);
        result.set(0, tail - num + 1);
        result.set(1, tail);
        return result;
    }

    protected boolean generSortArr(Stack<Integer> stack, int index, List<Integer> data) {
        if (stack.isEmpty()) {
            stack.push(index);
            return false;
        }
        Integer peek = stack.peek();
        if (data.get(peek) > data.get(index)) {
            if (stack.size() >= 2) {
                return true;
            }
            while (!stack.isEmpty()) {
                stack.pop();
            }
        }
        stack.push(index);
        return false;
    }

}
