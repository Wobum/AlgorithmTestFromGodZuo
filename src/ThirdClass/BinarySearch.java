package ThirdClass;

import javax.sound.midi.MidiChannel;

public class BinarySearch {
/**
 * @Auther: Wobum
 * @Date: 2018/11/20 16:13
 * @Description: 二分查找
 */
    // 循环实现
    public static int bSearch(int[] arr,int index){
        if (arr == null){
            return -1;
        }
        int high = arr.length - 1;
        int low = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] == index){
                return mid;
            }else if (arr[mid] < index){
                low = mid + 1;
            }else {
                high = mid -1;
            }
        }
        return -1;
    }

    // 递归写法
    public static int binarySearch(int[] arr, int index){
        return binarySearchInternally(arr, index, 0, arr.length - 1);
    }

    public static int binarySearchInternally(int[] arr, int index, int low, int high){
        int mid = low + (high - low) / 2;
        if (arr[mid] == index){
            return mid;
        }else if (arr[mid] < index){
            return binarySearchInternally(arr, index, mid + 1,high);
        }else {
            return binarySearchInternally(arr, index, low, mid - 1);
        }
    }

    //数组中有重复的元素，查找第一个等于给定值的元素
    public static int bSearch1(int[] arr, int index){
        if (arr == null){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] < index){
                low = mid + 1;
            }else if (arr[mid] > index){
                high = mid - 1;
            }else {
                if (mid == 0 || arr[mid - 1] != index) return  mid;
                else  high = mid - 1;
            }
        }
        return  -1;
    }

    //查找第一个大于等于给定值得元素。
    public static int bSearch2(int[] arr, int index){
        if (arr == null){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (arr[mid] < index){
                low = mid +1;
            }else {
                if (mid == 0 || arr[mid - 1] != index) return mid;
                else high = mid - 1;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,8,8,8,8,8,8,77,88,99};
        System.out.println(bSearch1(arr, 8));
        }
}
