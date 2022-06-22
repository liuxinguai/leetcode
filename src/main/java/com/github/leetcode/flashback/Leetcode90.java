package com.github.leetcode.flashback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(result,nums,used,new ArrayDeque<>());
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, boolean[] used, Deque<Integer> que) {
        result.add(new ArrayList<>(que));
        if (que.size() >= nums.length) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i - 1] == nums[i] && !used[i]) {
                    return;
                }
                que.addLast(nums[i]);
                used[i] = true;
                dfs(result, nums,used,que);
                used[i] = false;
                que.removeLast();
            }
        }
    }

}
