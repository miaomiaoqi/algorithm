package com.atguigu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 *
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待
 * 排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大
 * 的元素逐渐从前移向后部，就象水底下的气泡一样逐渐
 * 向上冒。
 *
 * 原始数组：3, 9, -1, 10, 20
 *
 * 第一趟排序
 * (1)  3, 9, -1, 10, 20   // 如果相邻的元素逆序就交换
 * (2)  3, -1, 9, 10, 20
 * (3)  3, -1, 9, 10, 20
 * (4)  3, -1, 9, 10, 20
 *
 * 第二趟排序
 * (1) -1, 3, 9, 10, 20 //交换
 * (2) -1, 3, 9, 10, 20
 * (3) -1, 3, 9, 10, 20
 *
 * 第三趟排序
 * (1) -1, 3, 9, 10, 20
 * (2) -1, 3, 9, 10, 20
 *
 * 第四趟排序
 * (1) -1, 3, 9, 10, 20
 *
 * 小结冒泡排序规则
 * (1) 一共进行 数组的大小-1 次 大的循环
 * (2)每一趟排序的次数在逐渐的减少
 * (3) 如果我们发现在某趟排序中，没有发生一次交换， 可以提前结束冒泡排序。这个就是优化
 *
 * @author miaoqi
 * @date 2023-04-15 17:42:39
 */
public class BubbleSort {

    public static void main(String[] args) {
        // int arr[] = {3, 9, -1, 10, 20};

        // System.out.println("排序前");
        // System.out.println(Arrays.toString(arr));


        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        // System.out.println("排序后");
        // System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        int temp;
        boolean flag = false;
        // 因为是两两比较, 所以只需要比较 length - 1 次
        for (int i = 0; i < arr.length - 1; i++) {
            // 最高一个位置不用比较,所以每次需要减去一个 i
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                // 如果没有进行过交换, 就代表已经有序了, 可以提前结束排序
                break;
            }
        }
    }

}
