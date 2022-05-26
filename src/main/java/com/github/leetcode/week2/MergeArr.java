package com.github.leetcode.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xinguai.liu
 */
public class MergeArr {

    public void merge(List<Integer> source, List<Integer> targe) {
        List<Integer> help = new ArrayList<>(source.size() + targe.size());
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < source.size() && tIndex < targe.size()) {
            help.add(source.get(sIndex) <= targe.get(tIndex) ? source.get(sIndex ++) : targe.get(tIndex ++));
        }
        while (sIndex < source.size()) {
            help.add(source.get(sIndex++));
        }
        while (tIndex < targe.size()) {
            help.add(targe.get(tIndex ++));
        }
        int index = 0;
        for (index = 0; index < targe.size(); index ++) {
            targe.set(index,help.get(index));
        }
        while (index < help.size()) {
            targe.add(help.get(index++));
        }
    }

    public void merge2(List<Integer> source, List<Integer> targe) {

    }


}
