package com.github.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] hits = null;
        hits = new int[21];
        for (int i = 0; i < 21; i++) {
            hits[i] = 5;
        }
        System.out.println(score(hits));
    }

    public static int score(int[] hits) {
        int sum = 0;
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            count.put(i,0);
        }
        for (int i = 0; i < hits.length; i++) {
            //TODO 计算本轮分数
            if(!map.containsKey(index)) {
                map.put(index,hits[i]);
                count.put(index,count.get(index) + 1);
            } else {
                count.put(index,count.get(index) + 1);
                map.put(index,map.get(index) + hits[i]);
            }
            //TODO 判断是否该结束本轮
            //  分数>=10 击球数为1，说明全中
            //   击球数为2  说明该轮2次机会全部击倒球 需要+后一轮的球数，且轮数+1
            //   分数小于10，且击球数为2 本轮结束
            //
            //TODO 条件  分数>=10 已经两次击球了 需要加上后一轮的
            Integer itemNum = map.get(index);
            if (itemNum >= 10) {
                if (count.get(index) == 1) {
                    index ++;
                } else if (count.get(index) == 2) {
                    map.put(index,map.get(index) + hits[i+1]);
                    index ++;
                    //TODO 结束统计的方式
                    if (index == 10) {
                        break;
                    }
                }
            } else {
                if (count.get(index) == 2) {
                    index ++;
                }
            }
        }
        for (Integer item : map.values()) {
            sum += item;
        }
        return sum;
    }

    //好了能听见我说话吗


}
