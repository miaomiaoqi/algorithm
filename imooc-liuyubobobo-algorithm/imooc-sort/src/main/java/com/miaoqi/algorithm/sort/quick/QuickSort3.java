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
public class QuickSort3 implements Sort {
    @Override
    public void sort(Integer[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    /**
     * 对 arr[l...r] 部分进行三路快速排序
     * 将 arr[l...r] 分为 <v ; ==v ; >v 三部分
     * 之后递归对 < v; > v 两部分继续进行三路快速排序
     */
    private void quickSort3Ways(Integer[] arr, int l, int r) {
        // 优化1: r - l <= 15 时进行插入排序, 不用一直向下递归了
        if (l >= r) {
            return;
        }
        // int p = partition3(arr, l, r);
        // quickSort3Ways(arr, l, p - 1);
        // quickSort3Ways(arr, p + 1, r);

        // partition
        // 快排选取一个分界元素, 默认是数组第一个元素, 如果在一个有序的数组中, 这样选择会退化成链表, 我们可以采用随机数
        // 优化2: 采用随机数选取
        Random random = new Random();
        ArrayUtil.swap(arr, l, (random.nextInt(r - l + 1) + l));

        // 该 partition 只判断了 < 的情况, 如果存在大量重复元素, 也会退化成链表, 可以改为双向比较
        // 优化3: 双向左侧比较 <= 右侧比较 >=, 使得重复元素分散开来
        int v = arr[l];

        int lt = l; // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1; // arr[lt+1...i) == v
        while (i < gt) {
            if (arr[i] < v) {
                ArrayUtil.swap(arr, i, lt + 1);
                i++;
                lt++;
            } else if (arr[i] == v) {
                i++;
            } else {
                ArrayUtil.swap(arr, i, gt - 1);
                gt--;
            }
            ArrayUtil.swap(arr, l, lt);
        }
        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }

}
