package com.github.leetcode.offer;

/**
 *  替换空格
 * @author xinguai.liu
 */
public class Offer05 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == 32) {
                builder.append("%20");
                continue;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        char[] s = " ".toCharArray();
        System.out.println(" ".toCharArray()[0]);
    }


}
