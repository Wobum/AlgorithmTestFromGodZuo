package SeventhClass;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author : Wobum
 * @Date : 2018/12/23 16:25
 * @Software : IntelliJ IDEA
 * @Description: 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目
 * 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数
 * 组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会
 * 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
 **/
public class BestArrange {
    public static class meeting {
        public int start;
        public int end;

        public meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class ProgramComparator implements Comparator<meeting> {

        @Override
        public int compare(meeting o1, meeting o2) {
            return o2.end - o1.end;
        }
    }

    // 贪心策略，结束时间最早的先开始
    public static int getMostTime(meeting[] arr, int start) {
        Arrays.sort(arr, new ProgramComparator()); //按照结束时间早进行排序
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (start < arr[i].start) {
                result++;
                start = arr[i].end;
            }
        }
        return result;
    }
}
