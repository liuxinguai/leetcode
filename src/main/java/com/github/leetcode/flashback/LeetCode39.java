package com.github.leetcode.flashback;

import java.util.*;

public class LeetCode39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,0, new ArrayDeque<>(), result,target);
        return result;
    }

    public void dfs(int[] candidates, int begin, Deque<Integer> deque, List<List<Integer>> result, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            deque.addLast(candidates[i]);
            dfs(candidates, i, deque, result,target-candidates[i]);
            deque.removeLast();
        }
    }


}
