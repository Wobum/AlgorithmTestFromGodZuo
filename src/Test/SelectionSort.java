package Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Wobum
 * @Date: 2018/12/9 14:18
 * @Description: 选择排序
 **/
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 1)
            return;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] generationArr() {
        int[] arr = new int[1000];
        Random ran = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(1000);
        }
        return arr;
    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (arr1 == arr2)
            return true;
        if ((arr1 != null && arr2 == null) || (arr1 == null && arr2 != null))
            return false;
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean succeed = true;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int[] arr1 = generationArr();
            int[] arr2 = arr1.clone();

            selectionSort(arr1);
            Arrays.sort(arr2);

            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Program takes " + (endTime - startTime) + " ms");
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
