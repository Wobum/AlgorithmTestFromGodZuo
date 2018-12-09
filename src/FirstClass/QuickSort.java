package FirstClass;

import java.util.Arrays;

public class QuickSort {
/**
 * @Auther: 81421
 * @Date: 2018/11/8 10:44
 * @Description:
 */
    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
        int[] res = partition(arr, l, r);
        quickSort(arr, l, res[0] - 1);
        quickSort(arr, res[1] + 1, r);
    }

    public static int[] partition(int[] arr, int l, int r){
        int less = l - 1;
        int more = r;
        while (l < more){
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            }else if (arr[l] > arr[r]){
                swap(arr, l, --more);
            }else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more - 1};
    }

    public static void  swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 打印数组
    public static void printArr(int[] arr){
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //生成一个随机整数数组
    public static int[] generatieRandomArr(int maxSize, int maxValue){
        if (maxSize < 1){
            return null;
        }
        int [] arr = new int[maxSize - 1];
        for (int i = 0; i < arr.length; i++){
            arr[i] = (int)(maxValue * Math.random());
        }
        return arr;
    }


    // 判断两个数组是否相等
    public static boolean isEqual(int[] arr1, int[] arr2){
        if((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if ((arr1 == null) && (arr2 == null)){
            return  true;
        }
        if (arr1.length != arr2.length){
            return  false;
        }
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    //复制一个数组
    public static int[] copyArr(int[] arr){
        if (arr == null){
            return  null;
        }
        int[] arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }


    public static void main(String[] args) {
       int testTime = 5000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++){
            int[] arr1 = generatieRandomArr(100,500);
            int[] arr2 = copyArr(arr1);
            quickSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1,arr2)){
                succeed =false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int index = 0;
        long res = (index - 1) / 2;
        System.out.println(res);
    }
}
