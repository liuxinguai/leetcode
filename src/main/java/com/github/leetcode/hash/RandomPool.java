package com.github.leetcode.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author xinguai.liu
 */
public class RandomPool {

    private final Map<String, Integer> stringIntegerMap = new HashMap<>();

    private final Map<Integer, String> integerStringMap = new HashMap<>();

    private Integer size = 0;

    private final Random random = new Random();

    public void insert(String str) {
        stringIntegerMap.put(str,size++);
        integerStringMap.put(stringIntegerMap.get(str),str);
    }

    public String getRandom() {
        return integerStringMap.get(generateRandom());
    }

    public String delete() {
        Integer random = generateRandom();
        String randomStr = integerStringMap.get(random);
        stringIntegerMap.remove(randomStr);
        integerStringMap.remove(random);
        if (random != size - 1) {
            String tailStr = integerStringMap.get(size - 1);
            integerStringMap.put(random,tailStr);
            stringIntegerMap.put(tailStr,random);
        }
        size --;
        return randomStr;
    }

    protected Integer generateRandom() {
        return random.nextInt(size);
    }
}
