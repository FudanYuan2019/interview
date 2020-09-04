package base.dp;


/**
 * 给定两个字符串A和B，返回两个字符串的最长公共子序列的长度。
 * 例如，A="1A2C3D4B56”，B="B1D23CA45B6A”，”123456"或者"12C4B6"都是最长公共子序列。
 * <p>
 * 给定两个字符串A和B，同时给定两个串的长度n和m，请返回最长公共子序列的长度。
 * 保证两串长度均小于等于300。
 * <p>
 * 测试样例：
 * "1A2C3D4B56",10,"B1D23CA45B6A",12
 * 返回：6
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 16:48
 * <p>
 * 解题思路：生成M*N的矩阵dp。dp[i][j]表示str1[0…i]与str1[0…j]的最长公共子序列长度。
 */
public class LCS {
    public int findLCS(String A, int n, String B, int m) {
        return core(A, n, B, m);
    }

    public int core(String A, int n, String B, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        int[][] dp = new int[n][m];
        // 初始化第0行
        for (int i = 0; i < m; i++) {
            if (A.charAt(0) == B.charAt(i)) {
                for (int j = i; j < m; j++) {
                    dp[0][j] = 1;
                }
                break;
            } else {
                dp[0][i] = 0;
            }
        }

        // 初始化第0列
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                for (int j = i; j < n; j++) {
                    dp[j][0] = 1;
                }
                break;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String A = "1A2C3D4B56";
        int n = A.length();
        String B = "B1D23CA45B6A";
        int m = B.length();
        int res = lcs.findLCS(A, n, B, m);
        System.out.println(res);
    }
}
