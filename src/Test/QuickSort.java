package Test;

import java.util.Arrays;

/**
 * @Author: Wobum
 * @Date: 2018/12/9 19:22
 * @Description: 如果要排序数组中下标为 p 到 q 的数字，我们可以在其中任意选择一个值作为 pivot，大于 pivot 的放在数组左边，小于 pivot 的放在
 *               数组的右边，等于的放在数组的中间，经过这一步骤后，我们把数组分成了三部分，中间等于部分是排好序的，运用递归，我们可以把左边的
 *               数组排好序，右边的数组排好序，直到区间缩小为 1.
 **/
public class QuickSort {
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    // main method
    public static void quickSort(int[] arr, int l, int h){
        if (l >= h) // Base case
            return;
        swap(arr, h, l + (int) (Math.random() * (h - l + 1))); // swap the random index with the high index.
        int[] res = partition(arr, l, h); // return the equals part left and right index
        quickSort(arr, l,res[0] -1); // recursive the left part
        quickSort(arr, res[1] + 1, h); // recursive the right part
    }

    // @return : The part of Equal
    public static int[] partition(int[] arr, int l, int h){
        int low = l -1;
        int high = h;
        while (l < high){
            if (arr[l] < arr[h])
                swap(arr, l++, ++low);
            else if (arr[l] == arr[h])
                l++;
            else
                swap(arr, l, --high);
        }
        swap(arr, h, high);
        return new int[]{low + 1,high - 1};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr){
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        boolean succeed = true;
        for (int i = 0; i < 100; i++){
            int[] arr1 = SelectionSort.generationArr();
            int[] arr2 = arr1.clone();

            quickSort(arr1);
            Arrays.sort(arr2);

            if (!SelectionSort.isEqual(arr1, arr2)){
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked !");
    }
}
