package com.github.leetcode.flashback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,nums,0,new ArrayDeque<>());
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, int start, Deque<Integer> que) {
        if (que.size() == nums.length) {
            result.add(new ArrayList<>(que));
            return;
        }
        result.add(new ArrayList<>(que));
        for (int i = start; i < nums.length; i++) {
            que.addLast(nums[i]);
            dfs(result,nums,i+1,que);
            que.removeLast();
        }
    }

}
