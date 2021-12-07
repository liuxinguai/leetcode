package com.github.leetcode.structure;

/**
 * @author xinguai.liu
 */
public class Manancher {


    public int findMpl(String str) {
        char[] search = buildSearch(str).toCharArray();
        int r = -1, c = -1;
        int[] palidromics = new int[search.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < search.length; i++) {
            if (i > r) {
                int palidromic = 1;
                palidromics[i] = findPalidromic(search,i,palidromic);
                c = i;
                r = i + palidromic - 1;
            } else {
                if (i + palidromics[2 * c - 1] < r) {
                    palidromics[i] = palidromics[2 * c - 1];
                } else if (i + palidromics[2 * c - 1] > r) {
                    palidromics[i] = r - i + 1;
                } else {
                    int palidromic = r - i + 1;
                    palidromics[i] = findPalidromic(search,i,palidromic);
                    c = i;
                    r = i + palidromic - 1;
                }
            }
            max = Math.max(palidromics[i],max);
        }
        return max - 1;
    }

    protected int findPalidromic(char[] search, int i, int palidromic) {
        while (i + palidromic < search.length && i - palidromic > -1) {
            if (search[i + palidromic] == search[i - palidromic]) {
                palidromic ++;
            } else {
                break;
            }
        }
        return palidromic;
    }

    public int findMaxPalindromicLength(String str) {
        char[] search = buildSearch(str).toCharArray();
        int R = -1;
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
