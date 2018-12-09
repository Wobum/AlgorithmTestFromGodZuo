package SixthClass;

import java.util.Random;

public class HashMapTest {
/**
 * @Auther: Wobum
 * @Date: 2018/12/4 22:09
 * @Description:
 */
    // 验证哈希函数的均匀性
    public static void test1(){
        String[] arrstr = new String[1000];
        Random ran = new Random();
        for(int i = 0; i < 1000; i++){
            arrstr[i] = String.valueOf(ran.nextInt(1000));
        }
        int[] cout = new int[10];

        for (String s : arrstr){
            int mod = Math.abs(s.hashCode() % 10);
            cout[mod] ++;
        }
        for (int i : cout){
            System.out.print(i + " ");
        }
    }

    // 位图
    public static void test2(){
        int[] arr = new int[10]; //0 ~ 319 bit 的数组

        int index = 237;

        System.out.println(index / 32); // 定位去哪个整数上找
        System.out.println(index % 32); // 定位到这个整数上的哪一位

        int res =(arr[index / 32] >> (index % 32)) & 1; // 取得 index 的状态
        System.out.println(res);
        arr[index / 32] = arr[index / 32] >>(1 << (index % 32)); // 设置 index 位置为 1
    }

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        String s = new String("dkslf");
        System.out.println(s);

    }
}
