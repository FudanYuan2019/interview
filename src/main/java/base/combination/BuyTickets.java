package base.combination;

/**
 * 2n个人排队买票，n个人拿5块钱，n个人拿10块钱，票价是5块钱1张，
 * 每个人买一张票，售票员手里没有零钱，问有多少种排队方法让售票员可以顺利卖票。
 * <p>
 * 给定一个整数n，请返回所求的排队方案个数。保证结果在int范围内。
 * <p>
 * 测试样例：
 * 1
 * 返回：1
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 17:17
 */
public class BuyTickets {
    public int countWays(int n) {
        return (int) Combination.getCAB(2 * n, n) / (n + 1);
    }
}
