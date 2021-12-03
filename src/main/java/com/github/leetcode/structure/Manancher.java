package com.github.leetcode.structure;

/**
 * @author xinguai.liu
 */
public class Manancher {


    public int findMaxPalindromicLength(String str) {
        char[] search = buildSearch(str).toCharArray();
        int R = 1;
        int c = -1;
        int[] palindromic = new int[search.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != search.length; i++) {
            palindromic[i] = R > i ? Math.min(palindromic[2*c - i], R - i) : 1;
            while (i + palindromic[i] < search.length && i - palindromic[i] > -1) {
                if (search[i + palindromic[i]] == search[i - palindromic[i]]) {
                    palindromic[i] ++;
                } else {
                    break;
                }
            }
            if (i + palindromic[i] > R) {
                R = i + palindromic[i];
                c = i;
            }
            max = Math.max(max,palindromic[i]);
        }
        return max - 1;
    }

    protected String buildSearch(String str) {
        char[] newArray = new char[str.length() * 2 + 1];
        char[] arrray = str.toCharArray();
        int index = 0;
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = ((i & 1) == 0) ? '#' : arrray[index ++];
        }
        return new String(newArray);
    }


}
