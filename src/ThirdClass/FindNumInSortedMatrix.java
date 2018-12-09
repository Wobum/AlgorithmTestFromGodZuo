package ThirdClass;

import java.rmi.MarshalException;

public class FindNumInSortedMatrix {
/**
 * @Auther: Wobum
 * @Date: 2018/11/16 11:16
 * @Description: 在行和列都是从下到大排序的矩阵中查找是否存在一个数，要求时间复杂度为 O(m + n),空间复杂度为 O(1)
 */
    public static boolean isContains(int[][] matrix, int K){
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0){
            if (matrix[r][c] == K){
                return true;
            }else if (matrix[r][c] > K){
                c--;
            }else{
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }
}
