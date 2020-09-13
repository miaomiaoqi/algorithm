package com.miaoqi.algorithm.sort.insert;

import com.miaoqi.algorithm.sort.Sort;

/**
 * 插入排序
 * O(n^2)时间复杂度
 * 类似扑克牌, 假设最开始已经是有序数组了, 要从第二个元素开始向前遍历, 找到自己的位置插入
 * 稳定, 因为向前找到相等的就直接插入后一个位置
 *
 * @author miaoqi
 * @date 2019-06-26
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // 向前寻找元素 arr[i] 合适的插入位置, 与选择排序相比, 可能会提前结束
            // for (int j = i; j > 0; j--) {
            //     if (arr[j] < arr[j - 1]) {
            //         ArrayUtil.swap(arr, j, j - 1);
            //     } else {
            //         break;
            //     }
            // }
            // for (int j = i; j > 0 && arr[j] < arr[j - 1]; j++) {
            //     ArrayUtil.swap(arr, j, j - 1);
            // }
            int e = arr[i];
            // j 保存元素 e 应该插入的位置, 改进版, 不进行交换, 最后确定位置后才插入, 性能提高
            // 内存循环可以很快的终止
            int j;
            for (j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
