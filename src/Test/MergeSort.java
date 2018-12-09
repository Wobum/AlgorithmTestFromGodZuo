package Test;

/**
 * @Author: Wobum
 * @Date: 2018/12/9 20:27
 * @Description: 归并排序核心思想，如果要排序一个数组，我们先把数组从中间分成前后两个数组，
 *                然后对前后两部分进行排序，再将排好序的两部分合并。
 **/
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r); // 必须用 mid + 1，因为 mid 有可能为 0,
        merge(arr, l, mid, r);
    }

    public static void  merge(int[] arr, int l, int m, int r){
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r){
            temp[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m){
            temp[i++] = arr[p1++];
        }

        while (p2 <= r){
            temp[i++] = arr[p2++];
        }

        for (int j = 0; j < temp.length; j++){
            arr[l + j] = temp[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,7,4,58,1,87,12,458,26,1,548,26,1,58,15};
        mergeSort(arr);
        QuickSort.printArr(arr);
    }
}
