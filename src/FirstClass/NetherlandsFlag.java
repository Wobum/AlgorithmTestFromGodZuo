package FirstClass;

public class NetherlandsFlag {
/**
 * @Auther: 81421
 * @Date: 2018/11/8 10:13
 * @Description: 给定一个数组和一个元素 p，要求大于 p 的放数组右边，小于 p 的放数组左边，等于 p 的放数组中间，时间复杂
 *               度 O(n),空间复杂度 O(1);
 */
    public static void getResult(int[] arr, int l, int r, int p){
        int left = l - 1; //表示小于区最右边的下标。
        int right = r + 1; // 表示大于区最左边的下标。
        while (l < right){
            if(arr[l] < p){
                swap(arr, l++, ++left);

            }else if (arr[l] > p){
                swap(arr, l, --right);
            }else {
                l++;
            }
        }
    }

    //数组内交换
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

    public static void main(String[] args) {
        int[] arr = generatieRandomArr(20,100);
        printArr(arr);
        getResult(arr, 0, arr.length - 1, 50);
        printArr(arr);
    }
}
