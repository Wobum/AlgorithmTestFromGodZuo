package SeventhClass;

/**
 * @Author : Wobum
 * @Date : 2018/12/23 11:10
 * @Software : IntelliJ IDEA
 * @Description: 在一个数组中，求最大的子数组异或和
 **/
public class MaxEOR {
    // 方法一： 暴力破解，时间复杂度为 O(n^3)
    public static int getMaxEOR1(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) { // 以 i 开头的情况下，每一个子数组的最大异或和
            for (int j = 0; j <= i; j++) { // 依次尝试 arr[i..i],...,arr[i...arr.length-1]
                max = Math.max(getArrEOR(arr, j, i), max); // 求 arr[i...j] 子数组的异或和
            }
        }
        return max;
    }

    // 求 arr[i...j] 的异或和
    public static int getArrEOR(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum ^= arr[i];
        }
        return sum;
    }

    //用 O(n) 的空间换 O(n) 的时间
    public static int getMaxEOR2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] eor = new int[arr.length];
        eor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            eor[i] = arr[i] ^ eor[i - 1]; // eor[i] 表示 arr[0...i] 的异或和
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) { // 求 arr[j...i] 的异或和
                /*if (j == 0) {
                    max = Math.max(max, eor[i]);
                } else {
                    max = Math.max(max, eor[i] ^ eor[j - 1]);
                }*/
                max = Math.max(max, j == 0 ? eor[i] : eor[i] ^ eor[j - 1]);
            }
        }
        return max;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
        arr[i] = (int) ((maxValue + 1) * Math.random())
                - (int) (maxValue * Math.random());
    }
        return arr;
}

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 30;
        int maxValue = 50;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int comp = getMaxEOR1(arr);
            int res = getMaxEOR2(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        //
        // // int[] arr = generateRandomArray(6, maxValue);
        // int[] arr = { 3, -28, -29, 2};
        //
        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i] + " ");
        // }
        // System.out.println("=========");
        // System.out.println(maxXorSubarray(arr));
        // System.out.println((int) (-28 ^ -29));

    }
}
