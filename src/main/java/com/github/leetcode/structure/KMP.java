package com.github.leetcode.structure;

/**
 * @author xinguai.liu
 */
public class KMP {

    public int getIndexOf(String source, String search) {
        if (source == null || search == null || source.length() < search.length()) {
            return -1;
        }
        char[] sourceArray = source.toCharArray();
        char[] searchArray = search.toCharArray();
        int sourceIndex = 0;
        int searchIndex = 0;
        int[] nextArray = getNextArray(searchArray);
        while (sourceIndex < sourceArray.length && searchIndex < searchArray.length) {
            if (sourceArray[sourceIndex] == searchArray[searchIndex]) {
                sourceIndex ++;
                searchIndex ++;
            } else if (nextArray[searchIndex] == -1) {
                sourceIndex ++;
            } else {
                searchIndex = nextArray[searchIndex];
            }
        }
        return searchIndex == searchArray.length ? sourceIndex - searchIndex : -1;
    }

    /**
     * 子串最长匹配前缀：
     *      最长匹配前缀的含义：
     *              比如：abcdefabcdemf,此时m的位置处的最长匹配前缀：4，m的下标为：12，f的最长匹配前缀是：0
     *
     * @param searchArray
     * @return
     */
    private int[] getNextArray(char[] searchArray) {
        int[] nextArray = new int[searchArray.length];
        nextArray[0] = -1;
        nextArray[1] = 0;
        int next = 0;
        int index = 2;
        while (index < searchArray.length) {
            if (searchArray[index - 1] == searchArray[next]) {
                nextArray[index++] = ++next;
            } else if (next > 0) {
                next = nextArray[next];
            } else {
                nextArray[index++] = 0;
            }
        }
        return nextArray;
    }


}
