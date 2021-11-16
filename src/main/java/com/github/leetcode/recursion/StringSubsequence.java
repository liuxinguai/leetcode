package com.github.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuxg
 */
public class StringSubsequence {

    public List<String> subsequence(String word) {
        List<String> result = new ArrayList<>();
        processor(word.toCharArray(),0,result);
        return result;
    }

    public List<String> subsequence2(String word) {
        List<String> result = new ArrayList<>();
        processor(word.toCharArray(),0,new ArrayList<>(),result);
        return result;
    }

    protected void processor(char[] str, int index, List<Character> selectChar,List<String> subSequence) {
        if (index == str.length) {
            subSequence.add(toString(selectChar));
            return;
        }
        List<Character> newList = new ArrayList<>(selectChar.size());
        copy(newList,selectChar);
        newList.add(str[index]);
        //选择
        processor(str,index + 1,newList,subSequence);
        //不选择
        processor(str,index + 1, selectChar,subSequence);
    }

    protected void processor(char[] str, int index, List<String> subSequence) {
        if (index == str.length) {
            subSequence.add(toString(str));
            return;
        }
        //选择
        processor(str,index + 1,subSequence);
        char tmp = str[index];
        str[index] = 0;
        //不选择
        processor(str,index + 1,subSequence);
        str[index] = tmp;
    }

    private String toString(List<Character> characters) {
        String result = "";
        for (int i = 0; i < characters.size(); i++) {
            result += characters.get(i);
        }
        return result;
    }

    private String toString(char[] characters) {
        String result = "";
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != 0) {
                result += characters[i];
            }
        }
        return result;
    }

    private void copy(List<Character> dest, List<Character> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringSubsequence().subsequence("liuxg"));
        System.out.println(new StringSubsequence().subsequence2("liuxg"));
    }

}
