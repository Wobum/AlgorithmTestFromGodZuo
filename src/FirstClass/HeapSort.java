package FirstClass;

import java.util.Arrays;

public class HeapSort {
/**
 * @Auther: 81421
 * @Date: 2018/11/11 10:22
 * @Description:
 */
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //先把整个数组简立为大根堆
        //第一种方式：从上往下建立。时间复杂度 O(n*logn)
        for (int i = 0; i < arr.length; i++){
            heapInsert(arr, i);
        }

        /*
        //第二种方式：丛下往上建立（更好）时间复杂度 O(n）
        for(int i = arr.length - 1; i >= 0 ; i--){
            int size = arr.length;
            heapfiy(arr, i,size);
        }
        */

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0){
            heapfiy(arr, 0 , size);
            swap(arr, 0, --size );
        }

    }

    /* @paramer: arr 表示传入数组
                 index 表示被修改的元素下标
                 size 表示整个堆的大小
     */
    public static void heapfiy(int[] arr, int index, int size){
        int L = index * 2 + 1; //该元素左叶子的位置
        while (L < size){
            int largest; //表示左右叶子中最大的那个叶子
            if (L + 1 < size && arr[L + 1] > arr[L]){
                largest = L + 1;
            }else {
                largest = L;
            }

            // 如果叶子节点中的最大值小于修改节点的值，跳出循环，否则，交换叶子节点和传入节点的位置，继续进行循环。
            if (arr[index] > arr[largest]){
                break;
            }else {
                swap(arr, index, largest);
                index = largest; // 交换完成后，被修改的元素位置为 largest
                L = index * 2 + 1;
            }

        }
    }

    //数组中新增一个元素 index，或者数组中任意一个位置的元素被改变，变得比以前大，将整个数组调成大根堆。
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j){
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
            heapSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1,arr2)){
                succeed =false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
