package com.github.leetcode.recursion;

/**
 * @author xinguai.liu
 */
public class Knapsack {

    public int maxValue(int[] weight, int[] values, int bag) {
        return processor(weight,values,0,0,bag);
    }

    protected int processor(int[] weight, int[] values, int index, int alreadyWeight, int bag) {
        if (alreadyWeight >= bag || index == weight.length) {
            return 0;
        }
        return Math.max(alreadyWeight + weight[index] <= bag ? values[index] + processor(weight, values, index + 1, alreadyWeight + weight[index], bag) : 0,
                processor(weight,values,index + 1,alreadyWeight,bag));
    }

}
