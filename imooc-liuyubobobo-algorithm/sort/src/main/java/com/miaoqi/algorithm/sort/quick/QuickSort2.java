package com.miaoqi.algorithm.sort.quick;

import com.miaoqi.algorithm.sort.Sort;
import com.miaoqi.algorithm.sort.util.ArrayUtil;

import java.util.Random;

/**
 * 快速排序
 * O(nlogn)时间复杂度
 * 选取一个元素放到它排序后的位置, 这个位置的左侧都小于这个元素, 右侧都大于这个元素, 递归进行这个操作
 * 最重要的过程是如果把这个元素移动到指定位置, 这个过程叫做 partition
 * 在一个有序的数组中, 快速排序最坏的情况会退化成链表 O(n^2)时间复杂度
 *
 * @author miaoqi
 * @date 2019-06-27
 */
public class QuickSort2 implements Sort {
    @Override
    public void sort(Integer[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    /**
     * 对 arr[l...r] 部分进行快速排序
     */
    private void quickSort2(Integer[] arr, int l, int r) {
        // 优化1: r - l <= 15 时进行插入排序, 不用一直向下递归了
        if (l >= r) {
            return;
        }
        int p = partition2(arr, l, r);
        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1, r);
    }

    /**
     * 对数组 arr 在[l...r]区间进行 partition 操作
     * 返回 p 使得 arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p]
     */
    private int partition2(Integer[] arr, int l, int r) {
        // 快排选取一个分界元素, 默认是数组第一个元素, 如果在一个有序的数组中, 这样选择会退化成链表, 我们可以采用随机数
        // 优化2: 采用随机数选取
        Random random = new Random();
        ArrayUtil.swap(arr, l, (random.nextInt(r - l + 1) + l));

        // 该 partition 只判断了 < 的情况, 如果存在大量重复元素, 也会退化成链表, 可以改为双向比较
        // 优化3: 双向左侧比较 <= 右侧比较 >=, 使得重复元素分散开来
        int v = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < v) {
                // 此时 i 的元素 >= v
                i++;
            }
            while (j >= l + 1 && arr[j] > v) {
                // 此时 j 的元素 <= v
                j--;
            }
            if (i > j) {
                break;
            }
            ArrayUtil.swap(arr, i, j);
            i++;
            j--;
        }
        ArrayUtil.swap(arr, l, j);
        return j;
    }
}
