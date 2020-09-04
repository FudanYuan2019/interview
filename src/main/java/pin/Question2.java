package pin;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/9/1 19:39
 */
public class Question2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    max = Math.max(max, change(matrix, i, j));
                }
            }
        }
        System.out.println(max);
    }

    private static int change(int[][] matrix, int row, int col) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        copy[row][col] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!(row == i && col == j) && copy[i][j] == 0) {
                    copy[i][j] = 1;
                    max = Math.max(max, getMax(copy, N, M));
                    copy[i][j] = 0;
                }
            }
        }
        return max;
    }

    private static int getMax(int[][] matrix, int N, int M) {
        int[][] dp = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (i == N - 1 && j == M - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (i + 1 == N && j + 1 < M) {
                    dp[i][j] = matrix[i][j] == 1 ? matrix[i][j + 1] + matrix[i][j] : 0;
                } else if (i + 1 < N && j + 1 == M) {
                    dp[i][j] = matrix[i][j] == 1 ? matrix[i + 1][j] + matrix[i][j] : 0;
                } else if (i + 1 < N && j + 1 < M){
                    dp[i][j] = matrix[i][j] == 1 ? dp[i + 1][j] + dp[i][j + 1] + matrix[i][j] : 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    private static void print(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

//3 4
//0 1 0 0
//1 0 1 1
//0 1 0 0