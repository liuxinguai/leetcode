package com.github.leetcode.flashback;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode77 {

    public List<List<Integer>> combine(int n, int k) {
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,0,candidates,k,new ArrayDeque<>());
        return result;
    }

    protected void dfs(List<List<Integer>> result, int begin, int[] candidates, int depth, Deque<Integer> deque) {
        if (depth == deque.size()) {
            result.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            deque.addLast(candidates[i]);
            dfs(result,i + 1,candidates,depth,deque);
            deque.removeLast();
        }
    }

}
