package Test;

import java.util.Arrays;

/**
 * @Author: Wobum
 * @Date: 2018/12/9 14:29
 * @Description:
 **/
public class InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; (j > 0) && (arr[j] < arr[j - 1]); j--) {
                SelectionSort.swap(arr, j, j - 1);
            }
        }
    }



    public static void main(String[] args) {
        boolean succeed = true;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int[] arr1 = SelectionSort.generationArr();
            int[] arr2 = arr1.clone();

            insertSort(arr1);
            Arrays.sort(arr2);
            if (!SelectionSort.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Program takes " + (endTime - startTime) + " ms");
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }
}
