package com.github.leetcode.week4;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 * @author xinguai.liu
 */
public class Leetcode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return processor(nums,0, nums.length - 1);
    }


    protected TreeNode processor(int[] nums,int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = processor(nums,left,mid - 1);
        root.right = processor(nums,mid + 1, right);
        return root;
    }



}
