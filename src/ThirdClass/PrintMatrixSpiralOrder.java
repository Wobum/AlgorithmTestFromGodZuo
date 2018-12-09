package ThirdClass;


public class PrintMatrixSpiralOrder {
    /**
     * @Auther: Wobum
     * @Date: 2018/11/16 08:54
     * @Description: 转圈打印一个矩阵
     */
    public static void spiralOrderPrint(int[][] matrix) {
        int sL = 0; // 开始位置的左下标
        int sR = 0; // 开始位置的右下标
        int eL = matrix.length - 1; // 结束位置的左下标
        int eR = matrix[0].length - 1; // 结束位置的右下标
        while (sL <= eL && sR <= eR){
            printEdge(matrix, sL++, sR++, eL--, eR--);
        }
    }

    public static void printEdge(int[][] matrix, int r1, int c1, int r2, int c2) {
        if (c1 == c2) {
            for (int i = r1; i <= r2; i++) {
                System.out.println(matrix[i][c1] + " ");
            }
        } else if (r1 == r2) {
            for (int i = c1; i <= c2; i++) {
                System.out.println(matrix[r1][i] + " ");
            }
        } else {
            int curC = c1;
            int curR = r1;
            while (curC != c2) {
                System.out.println(matrix[r1][curC] + " ");
                curC++;
            }// 此时 curC = c2,curR = r1;
            while (curR != r2) {
                System.out.println(matrix[curR][c2] + " ");
                curR++;
            }// 此时 curC = c2; curR = r2;
            while (curC != c1) {
                System.out.println(matrix[r2][curC] + " ");
                curC--;
            }// 此时 curC = c1; curR = r2;
            while (curR != r1){
                System.out.println(matrix[curR][c1] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}