package com.miaoqi.algorithm.sort.merge;

import com.miaoqi.algorithm.sort.Sort;

/**
 * 自顶向下递归归并排序
 * O(nlogn)时间复杂度
 * 将数组中的元素一半一半进行拆分, 直至拆到最底层 O(logn), 再向上回溯进行排序 O(n)
 *
 * @author miaoqi
 * @date 2019-06-26
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Integer[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序, 对 arr[l...r]的范围进行排序
     */
    private void mergeSort(Integer[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 优化2: 不用一直向下递归, 到达一定程度可以使用插入排序
        // if (r - l <= 15) {
        // 插入排序 arr, l, r
        // }
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        // 进行归并操作
        // 优化1: 两个区间已经是有序的了, 如果左区间大于右区间才进行排序
        if (arr[mid] > arr[mid + 1]) {
            merge(arr, l, mid, r);
        }
    }

    /**
     * 归并操作
     */
    private void merge(Integer[] arr, int l, int mid, int r) {
        // 开辟新空间存储左右空间的值
        int[] aux = new int[r - l + 1];
        // 从原始数组的 l 位置遍历到 r 位置将要归并的两组数据整合到 aux 中
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[l];
        }
        // 指向左侧开始位置
        int i = l;
        // 指向右侧开始位置
        int j = mid + 1;
        // 比较左右数组的值, 放入到原数组中
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
