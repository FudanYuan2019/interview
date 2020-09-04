package base.dp;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 假设只有 1 分、 2 分、五分、 1 角、二角、 五角、 1 元的硬币。
 * 在超市结账时，如果需要找零钱，收银员希望将最少的硬币数找给顾客。
 * 那么，给定需要找的零钱数目，如何求得最少的硬币数呢？
 *
 * @Author: Jeremy
 * @Date: 2019/5/31 17:08
 */
public class Exchange2 {
    public HashMap<String, Integer> map;

    public int minCoinsNum(int[] penny, int n, int aim) {
        if (penny == null || n == 0 || aim == 0) {
            return 0;
        }
//        return this.core1(penny, n - 1, aim);
//        return this.core2(penny, n - 1, aim);
        return this.core3(penny, n, aim);
    }


    /**
     * 暴力搜索
     *
     * @param penny
     * @param index
     * @param aim
     * @return
     */
    public int core1(int[] penny, int index, int aim) {
        if (aim < 0) {
            return 0;
        }
        if (index == 0) {
            return aim / penny[index];
        }
        int res = 0;
        if (index < 1) {
            return core1(penny, index, aim - penny[index]) + 1;
        }
        if (aim < penny[index]) {
            return core1(penny, index - 1, aim);
        }
        if (index >= 1 && aim >= penny[index]) {
            res = Math.min(core1(penny, index - 1, aim), core1(penny, index, aim - penny[index]) + 1);
        }
        return res;
    }


    /**
     * 记忆搜索
     *
     * @param penny
     * @param index
     * @param aim
     * @return
     */
    public int core2(int[] penny, int index, int aim) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (aim < 0) {
            return 0;
        }

        String key = String.valueOf(index) + "_" + String.valueOf(aim);

        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (index == 0) {
            return aim / penny[index];
        }
        int res = 0;
        if (index < 1) {
            return core1(penny, index, aim - penny[index]) + 1;
        }
        if (aim < penny[index]) {
            return core1(penny, index - 1, aim);
        }
        if (index >= 1 && aim >= penny[index]) {
            res = Math.min(core1(penny, index - 1, aim), core1(penny, index, aim - penny[index]) + 1);
        }
        map.put(key, res);
        return res;
    }

    /**
     * 动态规划
     *
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int core3(int[] penny, int n, int aim) {
        int[][] dp = new int[n][aim + 1];
        for (int i = 0; i < aim + 1; i++) {
            dp[0][i] = i / penny[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < aim + 1; j++) {
                if (j - penny[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - penny[i]] + 1);
                }
            }
        }
        return dp[n - 1][aim];
    }


    /**
     * 最少硬币数量
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0){
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < n; j++){
                if(i - coins[j] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Exchange2 exchange2 = new Exchange2();
        int[] penny = new int[]{1, 2, 5, 10};//,20,50,100
        int n = penny.length;
        int aim = 11;
        int res = exchange2.minCoinsNum(penny, n, aim);
        System.out.println(res);

        System.out.println(new Exchange2().coinChange(penny, aim));
    }
}
