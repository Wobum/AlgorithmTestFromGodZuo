package SeventhClass;

import java.util.PriorityQueue;

/**
 * @Author : Wobum
 * @Date : 2018/12/23 16:15
 * @Software : IntelliJ IDEA
 * @Description: 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如
 * 长度为20的 金条，不管切成长度多大的两半，都要花费20个铜
 * 板。一群人想整分整块金 条，怎么分最省铜板？
 **/
public class LessMoney {
    public static int getLessMoney(int[] arr) {
        if (arr == null)
            return 0;
        // 哈夫曼编码问题
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            priorityQueue.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (priorityQueue.size() > 1) {
            cur = priorityQueue.poll() + priorityQueue.poll();
            sum += cur;
            priorityQueue.add(cur);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10,20,30};
        System.out.println(getLessMoney(arr));
    }
}
