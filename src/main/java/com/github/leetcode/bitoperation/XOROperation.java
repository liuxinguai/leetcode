package com.github.leetcode.bitoperation;

/**
 * @author liuxg
 */
public class XOROperation {

    /**
     * 已知数组中只有两种数，一种数出现的次数为奇数次，一种数出现的次数为偶数次
     * 找出数组中出现奇数次的数字
     * @return 出现奇数次的数字
     */
    public int findOdd(int[] arr) {
        int item = 0;
        for (int curr : arr) {
            item ^= curr;
        }
        return item;
    }

    /**
     * 已知数组中只有三种数，两种数出现的次数为奇数次，一种数出现的次数为偶数次
     * 找出数组中出现奇数次的数字
     * @return 出现奇数次的两种数字
     */
    public int[] findTwoOdd(int[] arr) {
        int item = 0;
        for (int curr : arr) {
            item ^= curr;
        }
        int otherItem = 0;
        //找出右侧第一位1
        int rightBit = item & (~item + 1);
        for (int curr : arr) {
            if ((curr & rightBit) == 0) {
                otherItem ^= curr;
            }
        }
        return new int[] {item ^ otherItem, otherItem};
    }

    /**
     * 已知数组中只有二种数，一种数出现的次数为奇数次，一种数出现的次数为偶数次
     * 找出数组中出现奇数次的数字
     * @return 出现偶数次的数字
     */
    public int findEven(int[] arr) {
        int item = 0;
        for (int curr : arr) {
            item ^= curr;
        }
        for (int curr : arr) {
           if (item != curr) {
               return curr;
           }
        }
        return item;
    }

}
