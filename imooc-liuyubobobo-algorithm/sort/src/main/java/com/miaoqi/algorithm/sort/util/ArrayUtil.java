package com.miaoqi.algorithm.sort.util;

import com.miaoqi.algorithm.sort.Sort;

import java.util.Random;

/**
 * 数组工具类
 *
 * @author miaoqi
 * @date 2019-06-13
 */
public class ArrayUtil {

    public static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成 n 个元素的数组, 每个元素的随机范围为[rangeL, rangeR]
     */
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    public static void testSort(String sortName, Sort sort, Integer[] arr) {
        double startTime = System.nanoTime();
        sort.sort(arr);
        double endTime = System.nanoTime();

        System.out.println(String.format(sortName + " spend time: %f s", (endTime - startTime) / 1000000000.0));
        ArrayUtil.isSorted(arr);
    }

    public static boolean isSorted(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("arr is not sorted");
                return false;
            }
        }
        System.out.println("arr is sorted");
        return true;
    }

}
