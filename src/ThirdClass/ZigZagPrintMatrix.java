package ThirdClass;

public class ZigZagPrintMatrix {
    /**
     * @Auther: Wobum
     * @Date: 2018/11/16 10:21
     * @Description: "之" 字形打印一个矩阵。
     */
    public static void printMartixZigZag(int[][] matrix) {
        int aR = 0; // a 点的行数
        int aC = 0; // a 点的列数
        int bR = 0; // b 点的行数
        int bC = 0; // b 点的列数
        int eR = matrix.length - 1; // 结束的行数
        int eC = matrix[0].length - 1; // 结束的列数
        boolean fromUp = false; // 为 true 表示丛上往下打印，为 false 表示丛下往上打印
        while (aR <= eR) {
            printLevel(matrix, aR, aC, bR, bC, fromUp);
            if (aC == eC) {
                aR += 1;
            } else {
                aC += 1;
            }

            if (bR == eR) {
                bC += 1;
            } else {
                bR += 1;
            }
            fromUp = !fromUp;
        }
    }

    public static void printLevel(int[][] m, int aR, int aC, int bR, int bC, boolean fromUp) {
        if (fromUp) {
            while (aR < bR) {
                System.out.println(m[aR++][aC--] + " ");
            }
            System.out.println(m[bR][bC]);
        } else {
            while (bR > aR) {
                System.out.println(m[bR--][bC++] + " ");
            }
            System.out.println(m[aR][aC]);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        printMartixZigZag(matrix);

    }
}
