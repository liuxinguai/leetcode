package com.github.leetcode.structure;

import java.util.LinkedList;

/**
 * @author xinguai.liu
 */
public class SlidingWindow {


    private final int[] array;

    private int left = -1;

    private int right = -1;

    private final DullDecreaseDeque dull = new DullDecreaseDeque();

    public SlidingWindow(int[] array) {
        this.array = array;
    }

    class DullDecreaseDeque {

        private final LinkedList<Integer> items = new LinkedList<>();

        public int returnMax() {
            return items.getFirst();
        }

        public void add(Integer index) {
            while (!items.isEmpty()) {
                if (array[items.getLast()] <= array[index]) {
                    items.removeLast();
                } else {
                    break;
                }
            }
            items.addLast(index);
        }

        public void remove() {
            items.removeFirst();
        }
    }

    public void rightMove() {
        dull.add(++right);
    }

    public void leftMove() {
        if (left < right) {
            int max = dull.returnMax();
            if (left >= max) {
                dull.remove();
            }
            left ++;
            return;
        }
        throw new IllegalStateException("当前窗口左边界无法向右移动");
    }

    public int max() {
        return array[dull.returnMax()];
    }



}
