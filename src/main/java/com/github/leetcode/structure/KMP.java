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

    public int getIndexof(String str, String search) {
        if (str == null || search == null || str.trim().equals("") || search.trim().equals("")) {
            return -1;
        }
        char[] searchArray = search.toCharArray();
        char[] strArray = str.toCharArray();
        int[] longest = longest(searchArray);
        int strIndex = 0, searchIndex = 0;
        while (strIndex < strArray.length && searchIndex < searchArray.length) {
            if (searchArray[searchIndex] == strArray[strIndex]) {
                searchIndex ++;
                strIndex ++;
            } else if (longest[searchIndex] != -1) {
                searchIndex = longest[searchIndex];
            } else {
                strIndex ++;
            }
        }
        return searchIndex == searchArray.length? strIndex - searchIndex : -1;
    }


    protected int[] longest(char[] str) {
        int[] longest = new int[str.length];
        longest[0] = -1;
        longest[1] = 0;
        int index = 2;
        //longest[index - 1] == longest[1] = 0
        int match = 0;
        while (index < longest.length) {
            if (str[index - 1] == str[match]) {
                longest[index ++] = ++ match;
            } else if (longest[match] != -1) {
                match = longest[match];
            } else {
                longest[index ++] = match;
            }
        }
        return longest;
    }


}
