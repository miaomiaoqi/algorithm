package com.miaoqi.algorithm.sort;

import com.miaoqi.algorithm.sort.heap.HeapSort;
import com.miaoqi.algorithm.sort.merge.MergeSort;
import com.miaoqi.algorithm.sort.quick.QuickSort1;
import com.miaoqi.algorithm.sort.quick.QuickSort2;
import com.miaoqi.algorithm.sort.util.ArrayUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n = 1000000;
        Integer[] arr1 = ArrayUtil.generateRandomArray(n, 0, n);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        // SelectionSort ss = new SelectionSort();
        // ArrayUtil.testSort("SelectionSort O(n^2)", ss, arr1);
        // InsertionSort is = new InsertionSort();
        // ArrayUtil.testSort("InsertionSort O(n^2)", is, arr2);
        MergeSort ms = new MergeSort();
        ArrayUtil.testSort("MergeSort O(nlogn)", ms, arr3);
        QuickSort1 qs1 = new QuickSort1();
        ArrayUtil.testSort("QuickSort1 O(nlogn)", qs1, arr4);
        QuickSort2 qs2 = new QuickSort2();
        ArrayUtil.testSort("QuickSort2 O(nlogn)", qs2, arr5);
        HeapSort hs = new HeapSort();
        ArrayUtil.testSort("HeapSort O(nlogn)", hs, arr6);
    }
}
