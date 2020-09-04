package base.dp;

import java.util.*;

/**
 * 有数组pen ny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * <p>
 * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * <p>
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 *
 * @Author: Jeremy
 * @Date: 2019/5/28 21:32
 */
public class Exchange {
    // 用于记忆搜索的计算过的方案
    public static HashMap<String, Integer> map = new HashMap<>();

    public static int countWays(int[] penny, int n, int aim) {
        if (0 == n || null == penny || aim <= 0) {
            return 0;
        }
//        return core1(penny, 0, aim);
//        return core2(penny, 0, aim);
//        return core3(penny, n, aim);
//        return core4(penny, n, aim);
        return core5(penny, n, aim);
    }

    /**
     * 暴力搜索
     *
     * @param penny
     * @param index
     * @param aim
     * @return
     */
    public static int core1(int[] penny, int index, int aim) {
        int result = 0;
        if (index == penny.length) {
            result = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * penny[index] <= aim; i++) {
                result += core1(penny, index + 1, aim - i * penny[index]);
            }
        }
        return result;
    }

    /**
     * 记忆搜索
     *
     * @param penny
     * @param index
     * @param aim
     * @return
     */
    public static int core2(int[] penny, int index, int aim) {
        String key = index + "_" + aim;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int result = 0;
        if (index == penny.length) {
            result = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; i * penny[index] <= aim; i++) {
                 result += core2(penny, index + 1, aim - i * penny[index]);
            }
        }
        map.put(key, result);
        return result;
    }

    /**
     * 动态规划
     *
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public static int core3(int[] penny, int n, int aim) {
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            dp[0][i] = i % penny[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                for (int m = 0; m * penny[i] <= j; m++) {
                    dp[i][j] += dp[i - 1][j - m * penny[i]];
                }
            }
        }
        return dp[n - 1][aim];
    }

    /**
     * 动态规划优化
     *
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public static int core4(int[] penny, int n, int aim) {
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            dp[0][i] = i % penny[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                if (j < penny[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - penny[i]];
                }
            }
        }

        return dp[n - 1][aim];
    }

    /**
     * 动态规划，空间优化
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public static int core5(int[] penny, int n, int aim) {
        int[] dp = new int[aim + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = penny[i]; j < aim + 1; j++) {
                dp[j] += dp[j - penny[i]];
            }
        }

        return dp[aim];
    }

    public static void main(String[] args) {
        int[] penny = new int[]{1, 2, 3};
        int n = penny.length;
        int aim = 4;
        System.out.println(countWays(penny, n, aim));
    }
}
