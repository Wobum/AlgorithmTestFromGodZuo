package ThirdClass;

public class RotateMartix {
/**
 * @Auther: Wobum
 * @Date: 2018/11/16 09:30
 * @Description: 把一个正方形顺时针旋转 90 度
 */
    public static void rotate(int[][] matrix){
        int sL = 0;
        int sR = 0;
        int eL = matrix.length - 1;
        int eR = matrix[0].length - 1;
        while (sL < eL){
            rotateEdge(matrix, sL++, sR++, eL--, eR--);
        }
    }

    public static void rotateEdge(int[][] m, int sL, int sR, int eL, int eR){
        int num = eL - sL; // 表示总共需要旋转多少组的数字。

        for (int i = 0; i <= num; i++){
            int temp = m[sL][sR + i];
            m[sL][sR + i] = m[eL - i][sR];
            m[eL -i][sR] = m[eL][eR - i];
            m[eL][eR - i] = m[sL + i][eR];
            m[sL + i][eR] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
