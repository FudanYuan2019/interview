package huawei;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/2 19:01
 */
public class Question3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int N = scanner.nextInt();
        int[] w = new int[N];
        int[] v = new int[N];
        for (int j = 0; j < N; j++) {
            w[j] = scanner.nextInt();
        }
        for (int j = 0; j < N; j++) {
            v[j] = scanner.nextInt();
        }
        int value = getMaxValue(w, v, N, K);
        System.out.println(value);
    }

    public static int getMaxValue(int[] w, int[] v, int n, int cap) {
        if (w == null || v == null || n <= 0 || cap <= 0 || w.length == 0 || v.length == 0) {
            return 0;
        }
        int[] dp = new int[cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = cap; j > 0; j--) {
                if (j >= w[i]) {
                    dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
                }
            }
        }
        return dp[cap];
    }
}