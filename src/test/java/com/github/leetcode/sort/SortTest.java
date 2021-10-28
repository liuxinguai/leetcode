package com.github.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * 对数测试法
 */
public class SortTest {

    private final int[] arr = {5,4,3,2,1,8,9,10,8};



    @Test
    public void testSection() {
        SectionSort sectionSort = new SectionSort();
        int total = 10000, index  = 0;
        Random random = new Random();
        while (index++ < total) {
            int i = random.nextInt(index) + 1;
            int[] sourceArray = generatorRandomArray(i, 1000, random);
            int[] targetArray = new int[i];
            System.arraycopy(sourceArray,0,targetArray,0,i);
            sectionSort.sort(sourceArray);
            Arrays.sort(targetArray);
            assert isEquals(sourceArray,targetArray);
        }
        System.out.println("success");
    }


    @Test
    public void testBubble() {
        BubbleSort bubbleSort = new BubbleSort();

        bubbleSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void testInsert() {
        InsertSort insertSort = new InsertSort();

        insertSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }


    public int[] generatorRandomArray(int length, int limit,Random random) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1) * limit + 1;
        }
        return array;
    }

    public boolean isEquals(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }




}
