package com.miaoqi.algorithm.sort.heap;

import com.miaoqi.algorithm.sort.Sort;
import com.miaoqi.datastructure.heap.MaxHeap;

public class HeapSort implements Sort {
    @Override
    public void sort(Integer[] arr) {
        // MaxHeap<Integer> maxHeap = new MaxHeap();
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(arr);
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxHeap.add(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}
