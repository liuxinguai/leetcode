package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class LeetCode315 {

    public List<Integer> find(List<Integer> data) {
        List<Integer> result = new ArrayList<>(data.size());
        for (int i = 0; i < data.size(); i++) {
            int index = 0;
            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i) > data.get(j)) {
                    index ++;
                }
            }
            result.add(index);
        }
        return result;
    }




    // 索引数组
    private int[] index;

    // 辅助数组
    private int[] aux;

    // 统计数组
    // counter[0] 表示索引位置为 0 的那个数字有多少个逆序数
    // counter[1] 表示索引位置为 1 的那个数字有多少个逆序数
    private int[] counter;

    public List<Integer> countSmaller(int[] nums) {

        // 结果数组
        List<Integer> res = new ArrayList<>();

        // 获取数组的长度
        int len = nums.length;

        // 边界情况判断
        if (len == 0) return res;

        // 初始化操作
        aux = new int[len];

        counter = new int[len];

        index = new int[len];

        // 初始化操作
        // index[0] : 0
        // index[1] : 1
        for (int i = 0; i < len; i++){
            index[i] = i;
        }

        // 归并排序并统计
        merge_sort_recursive(nums, 0, len - 1);

        // counter[0] 表示索引位置为 0 的那个数字有多少个逆序数
        // counter[1] 表示索引位置为 1 的那个数字有多少个逆序数
        for (int i = 0; i < len; i++) {
            res.add(counter[i]);
        }
        return res;
    }

    // 归并排序递归版
    private void merge_sort_recursive(int[] nums, int left, int right) {

        // 1、分解到最小需要解决的地步，无法再分解了
        if (left == right) return;

        // 2、解决

        // 计算数组 nums 的中间位置
        int mid = (left + right ) / 2;

        // left1 为左区间的开始位置
        int left1 = left;

        // right1 为左区间的结束位置
        int right1 = mid;

        // left2 为右区间的开始位置
        int left2 = mid + 1;

        // right2 为右区间的结束位置
        int right2 = right;

        // 调用 merge_sort_recursive 函数，将 nums 数组中的 left1 到 right1 这一区间的数字排序
        merge_sort_recursive(nums, left1, right1);

        // 调用 merge_sort_recursive 函数，将 nums 数组中的 left2 到 right2 这一区间的数字排序
        merge_sort_recursive(nums, left2, right2);

        // 此时，【 left1，right1 】已经排好序
        // 此时，【 left2，right2 】已经排好序
        // 如果 right1 的数字 index[right1] 大于了 left2 的数字 index[left2]
        // 说明出现了逆序对，需要计算右侧小于当前元素的个数
        if (nums[index[right1]] > nums[index[left2]]) {
            // 开始执行归并操作，并且在归并过程中统计出右侧小于当前元素的个数
            sortAndCount(nums, left, mid, right);
        }
    }

    // 子序列排序并统计
    private void sortAndCount(int[] nums, int left, int mid, int right) {

        // 先将 index 中的元素都复制到 aux 中
        for(int i = left; i <= right; i++) {
            aux[i] = index[i];
        }

        // 此时，【 left，mid 】为一个区间
        // 此时，【 mid + 1，right 】为一个区间
        int i = left;

        int j = mid + 1;


        // 开始从头比较两个区间的元素
        for (int k = left; k <= right; k++) {
            // 如果 i > mid 说明 【 left，mid 】这个区间的所有元素都访问完毕了
            // 由于 【 mid + 1，right 】 为递增有序区间，所以这个区间里面的每个数字的右侧都没有比这个数字更小的元素
            if (i > mid) {

                //  还原 index[k] 的值
                index[k] = aux[j];
                // j++
                j++;

                // 否则说明 i 还在 【 left，mid 】这个区间
                // 如果 j > right ，说明【 mid + 1，right 】这个区间的所有元素都访问完毕了
                // 由于【 left，mid 】这个区间能出现的逆序数只能是在【 mid + 1，right 】这个区间
            } else if (j > right) {

                // 还原 index[k] 的值
                index[k] = aux[i];
                // i++
                i++;

                //【 mid + 1，right 】这个区间的所有元素都访问完毕，这个区间总共有 right - mid 个元素
                // 这些元素都是 i 指向的那个元素的逆序数，总共有 right - mid 个
                int count = right - mid;

                // index[k] 对应着原数组 nums 中索引为 k 的那个数
                int num = index[k];

                // 所以，这个数的逆序数需要加上 count
                counter[num] += count;

                // 否则说明 i 还在 【 left，mid 】这个区间
                // 同时 j 还在【 mid + 1，right 】 这个区间
                // 比较 i 和 j 指向的两个元素值的大小
            } else if (nums[aux[i]] <= nums[aux[j]]) {

                // 还原 index[k] 的值
                index[k] = aux[i];
                // i++
                i++;

                // j 在 【 mid + 1，right 】 这个区间
                // 从 mid + 1 到 j 有  j - (mid + 1) 是小于 nums[aux[i]]
                // 所以逆序数有 j - (mid + 1) 个
                int count = j - (mid + 1);

                // index[k] 对应着原数组 nums 中索引为 k 的那个数
                int num = index[k];

                // 所以，这个数的逆序数需要加上 count
                counter[num] += count;
            } else {
                // 还原 index[k] 的值
                index[k] = aux[j];
                // j++
                j++;
            }
        }
    }

}
