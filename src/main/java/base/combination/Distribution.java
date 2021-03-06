package base.combination;

/**
 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
 * <p>
 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
 * <p>
 * 测试样例：
 * 10,3
 * 返回：36
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 16:39
 */
public class Distribution {
    public int getWays(int n, int m) {
        // write code here
        if (m == 1){
            return 1;
        }
        return (int)Combination.getCAB(n - 1, m - 1);
    }

    public static void main(String[] args) {
        Distribution distribution = new Distribution();
        int res = distribution.getWays(6, 1);
        System.out.println(res);
    }
}
