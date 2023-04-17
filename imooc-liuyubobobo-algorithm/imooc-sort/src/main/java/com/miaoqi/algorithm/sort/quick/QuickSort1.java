package com.miaoqi.algorithm.sort.quick;

import com.miaoqi.algorithm.sort.Sort;
import com.miaoqi.algorithm.sort.util.ArrayUtil;

import java.util.Random;

/**
 * 快速排序
 * O(nlogn)时间复杂度
 * 选取一个元素放到它排序后的位置, 这个位置的左侧都小于这个元素, 右侧都大于这个元素, 递归进行这个操作
 * 最重要的过程是如何把这个元素移动到指定位置, 这个过程叫做 partition
 * 在一个有序的数组中, 快速排序最坏的情况会退化成链表 O(n^2)时间复杂度
 *
 * @author miaoqi
 * @date 2019-06-27
 */
public class QuickSort1 implements Sort {
    @Override
    public void sort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 对 arr[l...r] 部分进行快速排序
     */
    private void quickSort(Integer[] arr, int l, int r) {
        // 优化1: r - l <= 15 时进行插入排序
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * 对数组 arr 在[l...r]区间进行 partition 操作
     * 返回 p 使得 arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
     */
    private int partition(Integer[] arr, int l, int r) {
        // 快排选取一个分界元素, 默认是数组第一个元素, 如果在一个有序的数组中, 这样选择会退化成链表, 我们可以采用随机数
        // 优化2: 采用随机数选取
        Random random = new Random();
        ArrayUtil.swap(arr, l, (random.nextInt(r - l + 1) + l));
        int v = arr[l];
        // arr[l+1...j] < v; arr[j+1..i) > v
        // l: 当前分界元素下标, 默认第一个元素
        // j: 小于arr[l]的最后一个元素下标
        // j+1: 大于arr[l]的第一个元素
        // i: 待考察元素, 与 arr[l]做比较用

        int j = l;
        // 循环遍历待考察元素与第一个元素相比, 因此排除第一个元素
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                ArrayUtil.swap(arr, j + 1, i);
                j++;
            }
        }
        ArrayUtil.swap(arr, l, j);
        return j;
    }
}
