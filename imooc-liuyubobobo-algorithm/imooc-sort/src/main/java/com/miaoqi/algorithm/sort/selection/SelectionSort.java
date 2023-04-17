package com.miaoqi.algorithm.sort.selection;

import com.miaoqi.algorithm.sort.Sort;
import com.miaoqi.algorithm.sort.util.ArrayUtil;

/**
 * 选择排序
 * O(n^2)时间复杂度
 * 假设第一个元素是最小的元素, 遍历后续元素, 找到最小的下标与第一个元素交换
 * 不稳定, 因为向后遍历时可能会多次遍历更小的元素
 *
 * @author miaoqi
 * @date 2019-06-26
 */
public class SelectionSort implements Sort {

    @Override
    public void sort(Integer[] arr) {
        int n = arr.length;
        // 遍历 n-1 次, 因为最后一次不用遍历
        for (int i = 0; i < n - 1; i++) {
            // 默认第一个元素是最小的
            int minIndex = i;
            // 每次从 minIndex + 1 的位置开始比较, 一直比较到最后一个元素
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 每次比较后, minIndex 就是最小元素的下标, 与第一个元素进行交换
            ArrayUtil.swap(arr, i, minIndex);
        }
    }

}
