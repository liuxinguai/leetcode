package com.github.leetcode.flashback;

import java.util.*;

public class Leetcode40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(result,candidates,target, 0,new ArrayDeque<Integer>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, int begin, Deque<Integer> deque) {
        if (target == 0) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i - 1] == candidates[i]) {
                continue;
            }
            deque.addLast(candidates[i]);
            dfs(result, candidates, target - candidates[i], i + 1,deque);
            deque.removeLast();
        }
    }


}
