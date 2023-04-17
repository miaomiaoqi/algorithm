package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 *
 * 选择排序（select sorting）也是一种简单的排序方法。它的基本思想是：
 * 第一次从arr[0]~arr[n-1]中选取最小值，与arr[0]交换，
 * 第二次从arr[1]~arr[n-1]中选取最小值，与arr[1]交换，
 * 第三次从arr[2]~arr[n-1]中选取最小值，与arr[2]交换，…，
 * 第i次从arr[i-1]~arr[n-1]中选取最小值，与arr[i-1]交换，…,
 * 第n-1次从arr[n-2]~arr[n-1]中选取最小值，与arr[n-2]交换，
 * 总共通过n-1次，得到一个按排序码从小到大排列的有序序列
 *
 * 原始的数组 ： 101, 34, 119, 1
 * 第一轮排序 :   1, 34, 119, 101
 * 第二轮排序 :   1, 34, 119, 101
 * 第三轮排序 :   1, 34, 101, 119
 *
 * 说明：
 * 1. 选择排序一共有 数组大小 - 1 轮排序
 * 2. 每1轮排序，又是一个循环, 循环的规则(代码)
 * 2.1先假定当前这个数是最小数
 * 2.2 然后和后面的每个数进行比较，如果发现有比当前数更小的数，就重新确定最小数，并得到下标
 * 2.3 当遍历到数组的最后时，就得到本轮最小数和下标
 * 2.4 交换 [代码中再继续说 ]
 *
 * @author miaoqi
 * @date 2023-04-15 18:17:48
 */
public class SelectSort {

    public static void main(String[] args) {
        // int[] arr = {101, 34, 119, 1, -1, 90, 123};

        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        // 遍历 n-1 次, 因为最后一次不用遍历
        for (int i = 0; i < arr.length - 1; i++) {
            // 默认第一个元素是最小的
            int minIndex = i;
            // 每次从 minIndex + 1 的位置开始比较, 一直比较到最后一个元素
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 每次比较后, minIndex 就是最小元素的下标, 与第一个元素进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
