package com.github.leetcode.flashback;

import java.util.*;

public class Leetcode60 {


    public String getPermutation(int n, int k) {
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = i + 1;
        }
        boolean[] used = new boolean[n];
        ArrayList<String> result = new ArrayList<>();
        dfs(candidates,used,k,new ArrayDeque<Integer>(), result);
        return result.get(result.size() - 1);
    }

    private void dfs(int[] candidates, boolean[] used, int k, Deque<Integer> que, List<String> result) {
        if (que.size() == candidates.length) {
            if (result.size() < k) {
                StringBuilder builder = new StringBuilder();
                Iterator<Integer> iterator = que.iterator();
                while (iterator.hasNext()) {
                    builder.append(iterator.next());
                }
                result.add(builder.toString());
            }
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (used[i]) {
                continue;
            }
            if (result.size() == k) {
                return;
            }
            used[i] = true;
            que.addLast(candidates[i]);
            dfs(candidates,used,k,que,result);
            used[i] = false;
            que.removeLast();
        }
    }

}
