package com.github.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class StringArrangement {


    public List<String> arrangement(String str) {
        List<String> list = new ArrayList<>(str.length());
        processor(str.toCharArray(),0,list);
        return list;
    }


    protected void processor(char[] str, int index, List<String> result) {
        if (index == str.length) {
            result.add(String.valueOf(str));
            return;
        }
        boolean[] visit = new boolean[26];
        for (int i = index; i < str.length; i++) {
            if (!visit[str[i]-'a']) {
                visit[str[i] - 'a'] = true;
                swap(str,index,i);
                processor(str,i+1,result);
                swap(str,i,index);
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


}
