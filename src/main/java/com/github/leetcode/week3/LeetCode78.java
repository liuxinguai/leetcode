package com.github.leetcode.week3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode78 {

    List<Integer> t = new ArrayList<Integer>();

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> solute(int[] nums) {
        processor(nums,0);
        return ans;
    }

    protected void processor(int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[index]);
        processor(nums,index+1);

        t.remove(t.size() - 1);
        processor(nums,index+1);
    }

}
