package com.github.leetcode.flashback;

import java.util.*;

public class LeetCode47 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums,new boolean[nums.length],new ArrayDeque<>());
        return result;
    }

    protected void dfs(int depth, int[] nums, boolean[] used, Deque<Integer> deque) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                    continue;
                }
                used[i] = true;
                deque.addLast(nums[i]);
                dfs(depth+1, nums, used, deque);
                used[i] = false;
                deque.removeLast();
            }
        }
    }


}
