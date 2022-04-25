package com.github.leetcode.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xinguai.liu
 */
public class MaxTemp {

    private Stack<Stack<Integer>> stack = new Stack();

    public List<Integer> temperature(List<Integer> records) {
        List<Integer> result = new ArrayList<>(records.size());
        for (int i = 0; i < records.size(); i++) {
            result.add(0);
            processor(i,records,result);
        }
        return result;
    }

    private void processor(Integer index, List<Integer> records, List<Integer> result) {
        if (stack.isEmpty()) {
            Stack<Integer> list = new Stack<>();
            list.push(index);
            stack.push(list);
        } else {
            while (records.get(stack.peek().peek()) <= records.get(index)) {
                if (records.get(index) == records.get(stack.peek().peek())) {
                    stack.peek().push(index);
                    return;
                }
                Stack<Integer> peek = this.stack.pop();
                while (!peek.isEmpty()) {
                    Integer pop = peek.pop();
                    result.set(pop,index - pop);
                }
                if (stack.isEmpty()) {
                    break;
                }
            }
            Stack<Integer> list = new Stack<>();
            list.push(index);
            stack.push(list);
        }
    }


}
