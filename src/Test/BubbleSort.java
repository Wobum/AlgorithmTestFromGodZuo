package Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: Wobum
 * @Date: 2018/12/9 15:09
 * @Description: 冒泡排序
 **/
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort1(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SelectionSort.swap(arr, j, j + 1);
                    flag = false; // 表示有元素交换
                }
            }

            if (flag)
                break;
        }
    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        int lastExchangeIndex = 0; // 记录最后交换的元素位置
        int sortBroder = arr.length - 1; // 无序数列的边界

        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < sortBroder; j++) {
                if (arr[j] > arr[j + 1]) {
                    SelectionSort.swap(arr, j, j + 1);
                    flag = false;
                    lastExchangeIndex = j; // 有交换，则无序数列的边界。
                }
            }
            sortBroder = lastExchangeIndex;
            if (flag)
                break;
        }
    }

    public static int[] generationArr() {
        int[] arr = new int[10000];
        Random ran = new Random();
        for (int i = 0; i < 2000; i++) {
            arr[i] = ran.nextInt(200);
        }
        for (int i = 2000; i < arr.length; i++) {
            arr[i] = 2001;
        }
        return arr;
    }


    public static void main(String[] args) {
       /* boolean succeed = true;
        for (int i = 0; i < 100; i++) {
            int[] arr1 = SelectionSort.generationArr();
            int[] arr2 = arr1.clone();

            bubbleSort1(arr1);
            Arrays.sort(arr2);

            if (!SelectionSort.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");*/

        int[] arr3 = generationArr();
        int[] arr4 = arr3.clone();
        int[] arr5 = arr3.clone();

        long startTime = System.currentTimeMillis();
        bubbleSort(arr3);
        long endTime = System.currentTimeMillis();
        System.out.println("原冒泡排序耗时：" + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bubbleSort(arr4);
        endTime = System.currentTimeMillis();
        System.out.println("优化 1 后冒泡排序耗时：" + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        bubbleSort2(arr5);
        endTime = System.currentTimeMillis();
        System.out.println("优化 2 后冒泡排序耗时：" + (endTime - startTime) + " ms");

        Date date = new Date();
        System.out.println(date);
        DateFormat df = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
        System.out.println(df.format(date));
    }


}
