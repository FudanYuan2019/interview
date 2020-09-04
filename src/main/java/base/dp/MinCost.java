package base.dp;

/**
 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义c0，c1，c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需要的最少代价。
 * <p>
 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
 * <p>
 * 测试样例：
 * "abc",3,"adc",3,5,3,100
 * 返回：8
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 18:36
 * <p>
 * 思路：dp[i][j]代表A前i个字符串转化为B前i个字符串的最少代价。
 */
public class MinCost {
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        return core(A, n, B, m, c0, c1, c2);
    }

    public int core(String A, int n, String B, int m, int c0, int c1, int c2) {
        if (A.length() == 0 || B.length() == 0) {
            return 0;
        }
        A = " " + A;
        B = " " + B;
        int[][] dp = new int[n + 1][m + 1];
        // 初始化第0行
        dp[0][0] = 0;
        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = c0 * i;
        }

        // 初始化第0列
        for (int j = 1; j < n + 1; j++) {
            dp[j][0] = c1 * j;
        }

        //update=delete+insert,如果update花费更多就用delete+insert的花费之和替换
        if (c2 >= c0 + c1) {
            c2 = c0 + c1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    //如果两个字符串中A[i],B[j]的字符都一样的
                    //1.什么都不做就行，0操作
                    int dontChange = dp[i - 1][j - 1];
                    //2.比如由abcd→abcd=abc→abcd+A串删除d
                    int delete = dp[i - 1][j] + c1;
                    //3.比如由abcd→abcd=abcd→abc+B串插入d
                    int insert = dp[i][j - 1] + c0;
                    dp[i][j] = Math.min((Math.min(dontChange, delete)), insert);
                } else {
                    //1. A abcd → B abce = A abc→B abc + (A abcd → B abce, 替换d为e)
                    int replace = dp[i - 1][j - 1] + c2;
                    //2.比如由A abcd→B abce=A abc→B abce+A串删除d
                    int delete = dp[i - 1][j] + c1;
                    //3.比如由A abcd→B abce=A abcd→B abc+B串插入e
                    int insert = dp[i][j - 1] + c0;
                    dp[i][j] = Math.min((Math.min(replace, delete)), insert);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        MinCost minCost = new MinCost();
        String A = "abc";
        int n = A.length();
        String B = "adc";
        int m = B.length();
        int c0 = 3;
        int c1 = 5;
        int c2 = 3;
        int res = minCost.findMinCost(A, n, B, m, c0, c1, c2);
        System.out.println(res);
    }
}
