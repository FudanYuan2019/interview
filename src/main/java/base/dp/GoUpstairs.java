package base.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，
 * 请将结果Mod 1000000007
 * <p>
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 16:00
 */
public class GoUpstairs {
    public static Map<Integer, Integer> map = new HashMap<>();

    public int countWays(int n) {
        // write code here
        // return func1(n);
        return func3(n);
        // return func3(n);
    }

    /**
     * 暴力搜索
     * @param n
     * @return
     */
    public static int func1(int n) {
        System.out.println("计算 n = " + n);
        if (n <= 2) {
            return n;
        }
        return (func1(n - 2) + func1(n - 1)) % 1000000007;
    }


    /**
     * 记忆搜索
     * @param n
     * @return
     */
    public static int func2(int n) {
        if (map.containsKey(n)){
            return map.get(n);
        }
        System.out.println("计算 n = " + n);
        if (n <= 2) {
            map.put(n, n);
            return n;
        }
        int res = (func2(n - 2) + func2(n - 1)) % 1000000007;
        map.put(n, res);
        return res;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int func3(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[1] = 2;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n - 1];
    }

    /**
     * 空间复杂度为O(1)的动态规划
     * @param n
     * @return
     */
    public static int func4(int n) {
        int res = 0;
        int last = 2;
        int lastlast = 1;
        for (int i = 2; i < n; i++) {
            res = (last + lastlast) % 1000000007;
            lastlast = last;
            last = res;
        }
        return res;
    }

    public static void main(String[] args) {
        GoUpstairs goUpstairs = new GoUpstairs();
        System.out.println(goUpstairs.countWays(4));
    }
}
