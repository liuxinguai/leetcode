package com.github.leetcode.base;

import org.junit.Test;

public class SortTest {

    private final int[] arr = {5,4,3,2,1,8,9,10,8};

    @Test
    public void testSection() {
        SectionSort sectionSort = new SectionSort();

        sectionSort.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
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




}
