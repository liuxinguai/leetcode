package com.github.leetcode.sort;

import org.junit.Test;

/**
 * @author liuxg
 */
public class HeapStructureTest {

    @Test
    public void testBase() {
        HeapStructure<Integer> heapStructure = new HeapStructure<>(10);
        heapStructure.add(9);
        heapStructure.add(8);
        heapStructure.add(10);
        heapStructure.add(12);
        heapStructure.add(34);
        heapStructure.add(56);
        heapStructure.add(2);
        heapStructure.add(5);
        heapStructure.add(12);
        heapStructure.add(16);
        heapStructure.add(90);
        heapStructure.add(1);
        int index = heapStructure.size();
        for (int i = 0; i < index; i++) {
            System.out.println(heapStructure.poll());
        }
    }

    @Test
    public void testSort() {
        Integer[] arr = new Integer[] {42,26,45,36,25,48,79,56,47,23,15};
        HeapStructure.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    public void testToBucket() {
        Integer[] arr = new Integer[] {42,26,45,36,25,48,79,56,47,23,15};
        HeapStructure<Integer> heapStructure = HeapStructure.toBucket(arr);
        Integer item;
        while ((item = heapStructure.poll()) != null) {
            System.out.println(item);
        }
    }
}
