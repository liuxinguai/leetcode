package com.github.leetcode.flashback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode46 {

    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(0,nums,used,deque);
        return result;
    }

    protected void dfs(int depth, int[] nums, boolean[] used, Deque<Integer> deque) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                deque.addLast(nums[i]);
                dfs(depth + 1,nums,used,deque);
                used[i] = false;
                deque.removeLast();
            }
        }
    }

}
