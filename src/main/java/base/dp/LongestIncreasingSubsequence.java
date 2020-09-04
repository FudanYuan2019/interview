package base.dp;


import java.util.Arrays;

/**
 * 这是一个经典的LIS(即最长上升子序列)问题，请设计一个尽量优的解法求出序列的最长上升子序列的长度。
 * <p>
 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
 * <p>
 * 测试样例：
 * [1,4,2,5,3],5
 * 返回：3
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 16:26
 */
public class LongestIncreasingSubsequence {

    public int getLIS(int[] A, int n) {
        return core(A, n);
    }

    // 动态规划
    public static int core(int[] A, int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence main = new LongestIncreasingSubsequence();
        int[] A = new int[]{1, 4, 2, 5, 3, 0};
        int n = 6;
        System.out.println(main.getLIS(A, n));
    }
}
