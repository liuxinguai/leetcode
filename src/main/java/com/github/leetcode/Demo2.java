package com.github.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Demo2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<String> strings = Arrays.asList(line.split(","));
        int target = in.nextInt();
        solute(strings,target);
    }

    public static void solute(List<String> strings, int target) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String[] str = strings.get(i).split("-");
            if (str.length == 2) {
                int num0 = Integer.parseInt(str[0]);
                int num1 = Integer.parseInt(str[1]);
                if (num0 == target) {
                    list.add(String.format("%d-%d",num0+1,num1));
                } else if (num0 < target) {
                    if (num1 == target) {
                        list.add(String.format("%d-%d",num0,num1 - 1));
                    } else if (num1 > target){
                        int left = target - 1,right = target + 1;
                        if (left == num0) {
                            list.add(str[0]);
                        } else {
                            list.add(String.format("%d-%d",num0,left));
                        }
                        if (right == num1) {
                            list.add(str[1]);
                        } else {
                            list.add(String.format("%d-%d",right,num1));
                        }
                    } else {
                        list.add(strings.get(i));
                    }
                } else {
                    list.add(strings.get(i));
                }
            } else {
                if (Integer.parseInt(str[0]) != target) {
                    list.add(str[0]);
                }
            }
        }
        System.out.printf("%s",list.get(0));
        for (int i = 1; i < list.size(); i++) {
            System.out.printf(",%s",list.get(i));
        }
    }

}
