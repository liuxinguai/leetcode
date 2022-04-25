package com.github.leetcode.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author xinguai.liu
 */
public class Window {

    public List<Integer> max(List<Integer> records, int slide) {
        List<Integer> result = new ArrayList<>(records.size());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < records.size(); i++) {
            int left = i;
            int right = i + (slide - 1);
            if (right <= records.size() - 1) {
                result.add(process(left,right,records,queue));
            } else {
                break;
            }
        }
        queue.clear();
        return result;
    }

    private Integer process(int left, int right, List<Integer> records, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer top = queue.peek();
            if (top < left) {
                queue.poll();
            } else {
                break;
            }
        }
        for (int i = left; i <= right; i++) {
            Integer value = records.get(i);
            while (!queue.isEmpty()) {
                if (records.get(queue.peek()) < value) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (!queue.isEmpty()) {
                Integer top = queue.peek();
                if (top == i) {
                    continue;
                }
            }
            queue.offer(i);
        }
        return records.get(queue.peek());
    }




}
