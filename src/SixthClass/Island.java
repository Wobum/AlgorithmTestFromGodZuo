package SixthClass;

public class Island {
/**
 * @Auther: Wobum
 * @Date: 2018/12/2 11:18
 * @Description: 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 *               四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 *               矩阵中有多少个岛？
 */

    // 返回矩阵 arr 中的岛的个数
    public static int islandNum(int[][] arr){
        if (arr == null || arr[0] == null){
            return 0;
        }

        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] != 0 && arr[i][j] != 1){
                    return 0;
                }
            }
        }

        int res = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                if (arr[i][j] == 1){
                    res ++;
                    infect(arr, i, j);
                }
            }
        }

        return res;
    }

    // 感染与当前节点连接的所有 1 节点
    public static void infect(int[][] arr, int row, int col){
        if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || arr[row][col] != 1){ // Base case
            return;
        }

        arr[row][col] = 2;
        infect(arr, row, col + 1);
        infect(arr, row, col - 1);
        infect(arr, row + 1, col);
        infect(arr, row - 1, col);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(islandNum(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(islandNum(m2));

    }

}
