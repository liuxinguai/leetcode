package com.github.leetcode.week4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        processor(root,targetSum, new ArrayDeque<>(), result);
        return result;
    }

    public void processor(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> result) {
        if (root == null) {
            return ;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.right == null && root.left == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }
        processor(root.left,targetSum,path,result);
        processor(root.right, targetSum,path,result);
        path.pollLast();
    }

}
