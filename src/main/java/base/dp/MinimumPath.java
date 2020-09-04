package base.dp;

import java.util.HashMap;

/**
 * 有一个矩阵map，它每个格子有一个权值。
 * 从左上角的格子开始每次只能向右或者向下走，
 * 最后到达右下角的位置，路径上所有的数字累加起来就是路径和，
 * 返回所有的路径中最小的路径和。
 * <p>
 * 给定一个矩阵map及它的行数n和列数m，请返回最小路径和。保证行列数均小于等于100.
 * <p>
 * 测试样例：
 * [[1,2,3],[1,1,1]],2,3
 * 返回：4
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 16:15
 */
public class MinimumPath {
    public int[][] matrix;
    public int m;
    public int n;
    public int minDis = Integer.MAX_VALUE;

    public static HashMap<String, Integer> hashMap;

    public MinimumPath(int[][] matrix) {
        this.matrix = matrix;
        this.m = matrix.length;
        this.n = matrix[0].length;
    }

    public int getMin(int[][] matrix, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
//        return core1(matrix, n, m);
//        return core2(matrix, n, m);
        return core3(matrix, n, m);
//        return core4(matrix, n, m);
    }

    /**
     * 暴力搜素
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static int core1(int[][] matrix, int n, int m) {
        if (n == 1 && m == 1) {
            return matrix[n - 1][m - 1];
        }

        int res = matrix[n - 1][m - 1];
        if (n == 1) {
            res += core1(matrix, n, m - 1);
        } else if (m == 1) {
            res += core1(matrix, n - 1, m);
        } else {
            res += Math.min(core1(matrix, n, m - 1), core1(matrix, n - 1, m));
        }
        return res;
    }

    /**
     * 记忆搜索
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static int core2(int[][] matrix, int n, int m) {
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }

        String key = String.valueOf(n) + "_" + String.valueOf(m);
        if (n == 1 && m == 1) {
            hashMap.put(key, matrix[n - 1][m - 1]);
            return matrix[n - 1][m - 1];
        }
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        int res = matrix[n - 1][m - 1];
        if (n == 1) {
            res += core2(matrix, n, m - 1);
        } else if (m == 1) {
            res += core2(matrix, n - 1, m);
        } else {
            res += Math.min(core2(matrix, n, m - 1), core2(matrix, n - 1, m));
        }
        hashMap.put(key, res);
        return res;
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static int core3(int[][] matrix, int n, int m) {
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    /**
     * 动态规划, 优化内存空间
     *
     * @param matrix
     * @param n
     * @param m
     * @return
     */
    public static int core4(int[][] matrix, int n, int m) {
        int[] dp = new int[m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (j == 0){
                    dp[j] = dp[j];
                } else if (i == 0){
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                }
                dp[j] += matrix[i][j];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][4];
        matrix[0] = new int[]{533, 385, 398, 226};
        matrix[1] = new int[]{59, 529, 215, 203};
        matrix[2] = new int[]{466, 262, 210, 597};
        matrix[3] = new int[]{32, 359, 616, 194};
        matrix[4] = new int[]{322, 485, 552, 493};
        MinimumPath minimumPath = new MinimumPath(matrix);
        int res = minimumPath.getMin(matrix, matrix.length, matrix[0].length);
        System.out.println(res);
    }
}
