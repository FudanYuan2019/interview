package pin;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/1 19:01
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] id = new int[]{2, 1, 3, 8, 4, 7, 5, 6};
        int[][] matrix = new int[n][n];
        // 偶数
        if (n % 2 == 0) {
            matrix[0][n / 2] = 1;
            matrix[0][n / 2 - 1] = 1;
            matrix[n - 1][n / 2] = 1;
            matrix[n - 1][n / 2 - 1] = 1;

            matrix[n / 2][0] = 1;
            matrix[n / 2 - 1][0] = 1;

            matrix[n / 2][n - 1] = 1;
            matrix[n / 2 - 1][n - 1] = 1;
        } else {
            matrix[0][n / 2 - 1] = 1;
            matrix[0][n / 2 + 1] = 1;

            matrix[n - 1][n / 2 - 1] = 1;
            matrix[n - 1][n / 2 + 1] = 1;

            matrix[n / 2 - 1][0] = 1;
            matrix[n / 2 + 1][0] = 1;

            matrix[n / 2 - 1][n - 1] = 1;
            matrix[n / 2 + 1][n - 1] = 1;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    System.out.print(id[count++] + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
