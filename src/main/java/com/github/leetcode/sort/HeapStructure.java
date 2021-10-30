package com.github.leetcode.sort;

/**
 * @author liuxg
 */
public class HeapStructure<T extends Comparable> {

    private Comparable[] arr;

    private int capacity = 0;

    private int headSize = 0;

    public HeapStructure(int capacity) {
        this.capacity = capacity;
        this.arr = new Comparable[capacity];
    }

    protected void headInsert() {
        int index = headSize - 1;
        while (more(arr[index], arr[(index - 1) / 2])) {
            swap(index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    protected void headify() {
       int index = 0, left = 2 * index + 1;
       while (left < headSize) {
           int largeIndex = (left + 1) < headSize && more(arr[left + 1] , arr[left]) ? left + 1 : left;
           if (more(arr[largeIndex],arr[index])) {
               swap(index,largeIndex);
           } else {
               break;
           }
           index = left;
           left = 2 * left + 1;
       }

    }

    protected void swap(int i , int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected boolean more(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) > 0 ? true : false;
    }


    public void add(T t) {
        if (headSize == capacity) {
            Comparable[] target = new Comparable[2 * capacity];
            System.arraycopy(arr,0,target,0,capacity);
            this.capacity = 2 * capacity;
            this.arr = target;
        }
        arr[headSize++] = t;
        headInsert();
    }

    public T poll() {
        if (headSize == 0 ) {
            return null;
        }
        T data = (T)arr[0];
        swap(0,--headSize);
        headify();
        return data;
    }

    public int size() {
        return headSize;
    }

    public static <T extends Comparable> HeapStructure<T> toBucket(T[] arr) {
        HeapStructure<T> heapStructure = new HeapStructure<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heapStructure.add(arr[i]);
        }
        return heapStructure;
    }

    public static <T extends Comparable> void sort(T[] arr) {
        HeapStructure<T> heapStructure = toBucket(arr);
        int index = arr.length - 1;
        T item;
        while ((item = heapStructure.poll()) != null) {
            arr[index--] = item;
        }
    }
}
