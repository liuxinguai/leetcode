package com.github.leetcode.recursion;

public class CodeToString {


    public int codeToStr(String str) {
        return process(str.toCharArray(),str.length());
    }

    protected int process(char[] codes, int index) {
        if (index == codes.length) {
            return 1;
        }
        if (codes[index] == '0') {
            return 0;
        } else if(codes[index] == '1') {
            int result = process(codes,index + 1);
            if(index + 1 < codes.length) {
                result += process(codes, index + 2);
            }
            return result;
        } else if (codes[index] == '2') {
            int result = process(codes, index + 1);
            if (index + 1 < codes.length && (codes[index + 1] >= '0' && codes[index + 1] <= '6')) {
                result += process(codes, index + 2);
            }
            return result;
        }
        return process(codes,index + 1);
    }

}
