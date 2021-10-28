package com.github.leetcode.sort;

/**
 * <ul>归并排序：将一个数组按照二分法分别将两侧排好序，然后在将左侧部分和右侧部分合并到一个辅助空间上，在将这个辅助空间上的数复制回原数组</ul>
 *  <li>比如：[5,6,7,1,2,9,8,7,10,7,5,4,6]</li>
 *  <li>二分后：[5,6,7,1,2,9],[8,7,10,7,5,4,6]</li>
 *  <li>二分排好序后：arr_left[2,2,5,6,7,9],arr_right[4,5,6,7,7,8,9]</li>
 *  <li>merge过程: int left = 0,int right = 0=>arr_left[left] < arr_right[right]->辅助空间 [2],left = 1,right = 0</li>
 *  <li>merge过程：int left = 1,int right = 0=>arr_left[left] < arr_right[right]->辅助空间 [2,2],left = 2,right = 0</li>
 *  <li>merge过程：int left = 2,int right = 0=>arr_left[left] > arr_right[right]->辅助空间 [1,2,4],left = 2,right = 1</li>
 *  <li>merge过程：int left = 2,int right = 1=>arr_left[left] = arr_right[right]->辅助空间 [1,2,4,5],left = 3,right = 1</li>
 *  <li>merge过程：int left = 3,int right = 1=>arr_left[left] > arr_right[right]->辅助空间 [1,2,4,5,5],left = 3,right = 2</li>
 * @author liuxg
 */
public class MergeSort {


    public void sort(int[] arr) {
        process(arr,0,arr.length - 1);
    }

    public int mininumSum(int[] arr) {
        return new MininumSumSolute().answer(arr);
    }

    public int reversePair(int[] arr) {
        return new ReversePairSolute().answer(arr);
    }

    protected void process(int arr[], int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr,left,mid);
        process(arr,mid + 1,right);
        merge(arr, left, mid, right);
    }

    protected void merge(int arr[],int left, int mid,int right) {
        int[] help = new int[right - left + 1];
        int index = 0,l = left,r = mid + 1;
        while (l <= mid && r <= right) {
            help[index++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= mid) {
            help[index++] = arr[l++];
        }
        while (r <= right) {
            help[index++] = arr[r++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[left++] = help[i];
        }
    }

    class ReversePairSolute {

        /**
         *
         * <span>在一个数组中，左边的数如果比右边的数大，则称两个数构成一个逆序对，找出数组中所有的逆序对的个数</span>
         *  <ul>例如：[1,3,4,2,5]   [5,6,7,1,2,9,8,7,10,7,5,4,6]
         *      <li> 1右边比1小的数没有，0个逆序对</li>
         *      <li> 3右边比3小的数有：1个逆序对(3,2)</li>
         *      <li> 4右边比4小的数有：1个逆序对(4,2)</li>
         *      <li> 2右边比2小的数有：0个逆序对</li>
         *      <li> 5右边比5小的数有：0个</li>
         *      <li> 和为：0+1+1+1+0=3</li>
         *
         *  </ul>
         *  此时可以采用归并排序法
         * @param arr 数组
         * @return 最小和
         */
        public int answer(int[] arr) {
            return process(arr,0, arr.length - 1);
        }

        protected int process(int[] arr, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = left + ((right - left) >> 1);
            return process(arr, left, mid) + process(arr,mid + 1, right) + merge(arr, left, mid, right);
        }

        protected int merge(int[] arr, int left, int mid, int right) {
            int[] help = new int[right - left + 1];
            int r = mid + 1, l = left, sum = 0, index = 0;
            while (l <= mid && r <= right) {
                if (arr[l] > arr[r]) {
                    //TODO 注意有个坑，我以前的写法：sum ++ 这种统计出来是不正确的，因为你把右边小的数放到有序集合中了后续左边有序的数就没法跟这个数比较了
                    sum += (mid - l + 1) * 1;
                }
                help[index++] = arr[l] >= arr[r] ? arr[r++] : arr[l++];
            }
            while (l <= mid) {
                help[index++] = arr[l++];
            }
            while (r <= right) {
                help[index++] = arr[r++];
            }
            for (int i = 0; i < help.length; i++) {
                arr[left++] = help[i];
            }
            return sum;
        }

    }


    class MininumSumSolute {

        /**
         *
         * <span>在一个数组中，每一个数的左边比当前数小的数累加起来，称为这个数组的小和</span>
         *  <ul>例如：[1,3,4,2,5]
         *      <li> 1左边比1小的数没有，0</li>
         *      <li> 3左边比3小的数，1</li>
         *      <li> 4左边比4小的数，1，3</li>
         *      <li> 2左边比2小的数，1</li>
         *      <li> 5左边比5小的数，1，3，4，2</li>
         *      <li> 和为：0+1+1+3+1+1+3+4+2=16</li>
         *
         *  </ul>
         * <ul>求一个数组的小和<ul/>
         *  反过来看成：数组右侧中比当前数大的数个数*当前数累加，比如：[1,3,4,2,5]，对于1而言，数组右侧比1大的数有：4个；
         *                          对于3而言，数组右侧比3大的数有：2个；
         *                          对于4而言，数组右侧比4大的数有：1个；
         *                          对于2而言，数组右侧比2大的数有：1个；
         *                          对于5而言，数组右侧比5大的数有：0个；
         *                          => 1 * 4 + 4 * 1 + 2 * 3 + 2 * 1 = 16
         *  此时可以采用归并排序法
         * @param arr 数组
         * @return 最小和
         */
        public int answer(int[] arr) {
            return process(arr,0, arr.length - 1);
        }

        protected int process(int[] arr, int left, int right) {
            if (left == right) {
                return 0;
            }
            int mid = left + ((right - left) >> 1);
            return process(arr, left, mid) + process(arr,mid + 1, right) + merge(arr, left, mid, right);
        }

        protected int merge(int[] arr, int left, int mid, int right) {
            int[] help = new int[right - left + 1];
            int r = mid + 1, l = left, sum = 0, index = 0;
            while (l <= mid && r <= right) {
                if (arr[l] < arr[r]) {
                    sum += arr[l] * (right - r + 1);
                }
                help[index++] = arr[l] >= arr[r] ? arr[r++] : arr[l++];
            }
            while (l <= mid) {
                help[index++] = arr[l++];
            }
            while (r <= right) {
                help[index++] = arr[r++];
            }
            for (int i = 0; i < help.length; i++) {
                arr[left++] = help[i];
            }
            return sum;
        }
    }


}
