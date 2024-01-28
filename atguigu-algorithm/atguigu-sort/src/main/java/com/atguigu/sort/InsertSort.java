package com.atguigu.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 插入排序（Insertion Sorting）的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
 * 将它插入到有序表中的适当位置，使之成为新的有序表
 *
 * 即将一个数组分作左右两个部分, 从右边无序的第一个向左边有序的逐次查找插入
 *
 * @author miaoqi
 * @date 2023-04-15 21:16:7
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        // 创建要给80000个的随机的数组
        // int[] arr = new int[80000];
        // for (int i = 0; i < 80000; i++) {
        //     arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        // }

        System.out.println("插入排序前");
        System.out.println(Arrays.toString(arr));
        // Date data1 = new Date();
        // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String date1Str = simpleDateFormat.format(data1);
        // System.out.println("排序前的时间是=" + date1Str);

        insertSort2(arr); //调用插入排序算法

        // Date data2 = new Date();
        // String date2Str = simpleDateFormat.format(data2);
        // System.out.println("排序前的时间是=" + date2Str);

        System.out.println("插入排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        // 待插入的值
        int insertVal = 0;
        // 从右边第一个位置开始遍历
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            // 从左边最后一个位置向前查找, 直到找到一个比当前小的数就交换
            // 如果下标合法, 并且最小值小于左边的值, 就将左边的值右移
            int j;
            for (j = i - 1; j >= 0 && arr[j] < insertVal; j--) {
                arr[j + 1] = arr[j];
            }
            // 因为 j-- 比较之后不合法, 所以要 +1 赋值
            arr[j + 1] = insertVal;
        }
    }

    public static void insertSort2(int[] arr) {
        int insertVal = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] < insertVal) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = insertVal;
        }
    }

}
