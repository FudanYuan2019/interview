package base.dp;

/**
 * 一个背包有一定的承重cap，有N件物品，
 * 每件都有自己的价值，记录在数组v中，
 * 也都有自己的重量，记录在数组w中，
 * <p>
 * 每件物品只能选择要装入背包还是不装入背包，
 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
 * <p>
 * 给定物品的重量w价值v及物品数n和承重cap。请返回最大总价值。
 * <p>
 * 测试样例：
 * [1,2,3],[1,2,3],3,6
 * 返回：6
 *
 * @Author: Jeremy
 * @Date: 2019/5/29 17:54
 * <p>
 * 思路：dp[i][j]代表总质量weight<=j时，前i个物品的最大价值value。
 */
public class Backpack {
    public int maxV = Integer.MIN_VALUE;
    public int maxW = Integer.MIN_VALUE;
    public int[] w;
    public int[] v;
    public int cap;
    public int n;

    public Backpack(int[] w, int[] v, int n, int cap) {
        this.w = w;
        this.v = v;
        this.n = n;
        this.cap = cap;
    }

    public int maxValue() {
        // write code here
        return core(w, v, n, cap);
    }

    public void getMaxWeight(int i, int cw) {
        if (cw == cap || i == n) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        getMaxWeight(i + 1, cw);
        if (cw + w[i] <= cap) {
            getMaxWeight(i + 1, cw + w[i]);
        }
    }

    public int getMaxWeightWithDP() {
        int[][] dp = new int[n][cap + 1];  // dp[i][j] 代表 第i个物品选择放入背包或不放入背包的状态
        dp[0][0] = 1;  // 第0个物品不放入背包
        if (w[0] <= cap) {  // 第0个物品放入背包
            dp[0][w[0]] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= cap; j++) {  // 不把第i个物品放入背包
                if (dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                }
            }

            for (int j = 0; j <= cap - w[i]; j++) {  // 把第i个物品放入背包
                if (dp[i - 1][j] == 1) {
                    dp[i][j + w[i]] = 1;
                }
            }
        }
        for (int i = cap; i >= 0; i--) {
            if (dp[n - 1][i] == 1) {
                return i;
            }
        }
        return 0;
    }

    public int getMaxWeightWithDP2() {
        int[] dp = new int[cap + 1];  // dp[j]代表重量等于j的状态是否存在，1为存在，0为不存在
        dp[0] = 1;
        if (w[0] <= cap) {
            dp[w[0]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for(int j = cap; j >= w[i]; j--){
                dp[j] = dp[j] | dp[j - w[i]];
            }
//            for (int j = cap - w[i]; j >= 0; j--) {  // 下标从大到小，避免重复计算
//                if (dp[j] == 1) {
//                    dp[j + w[i]] = 1;
//                }
//            }
        }
        for (int i = cap; i >= 0; i--) {
            if (dp[i] == 1) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 第i个物品，对应的重量和价值
     *
     * @param i
     * @param cw
     * @param cv
     * @return
     */
    public void getMaxValue(int i, int cw, int cv) {
        if (cw == cap || i == n) {  // cw==w表示装满了，i==n表示物品都考察完了
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        getMaxValue(i + 1, cw, cv);
        if (cw + w[i] <= cap) {
            getMaxValue(i + 1, cw + w[i], cv + v[i]);
        }
    }

    public static int core(int[] w, int[] v, int n, int cap) {
        if (n == 0 || w.length == 0 || v.length == 0 || cap == 0) {
            return 0;
        }

        int[][] dp = new int[n][cap + 1];

        for (int i = 0; i < cap + 1; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < cap + 1; j++) {
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int[] dp2 = new int[cap + 1];
        for (int i = 0; i < n; i++) {
            for (int j = cap; j > 0; j--) {
                if (j >= w[i]) {
                    dp2[j] = Math.max(dp2[j], dp2[j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp2[cap]);
        return dp[n - 1][cap];
    }

    public static void main(String[] args) {
        int[] w = new int[]{16, 36, 25, 19, 26, 23};
        int[] v = new int[]{619, 363, 582, 163, 487, 344};
        int n = 6;
        int cap = 35;
        Backpack backpack = new Backpack(w, v, n, cap);
        int res = backpack.maxValue();
        backpack.getMaxWeight(0, 0);
        backpack.getMaxValue(0, 0, 0);
        int maxW = backpack.getMaxWeightWithDP();
        int maxW2 = backpack.getMaxWeightWithDP2();
        System.out.println(maxW + "  " + maxW2);
        System.out.println(res + " " + backpack.maxW + " " + backpack.maxV);
    }
}
