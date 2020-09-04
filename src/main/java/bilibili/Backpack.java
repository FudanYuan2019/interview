package bilibili;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/4 16:18
 */
public class Backpack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i < N; i++) {
            v[i] = scanner.nextInt();
        }

        int maxValue = getMaxValue(N, M, w, v);
        System.out.println(maxValue);
    }

    public static int getMaxValue(int N, int M, int[] w, int[] v) {
        if (N == 0 || M == 0 || w == null || w.length == 0 || v == null || v.length == 0) {
            return 0;
        }
        int[][] dp = new int[N][M + 1];
        for (int i = 0; i < M + 1; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N - 1][M];
    }
}
