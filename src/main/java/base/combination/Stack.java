package base.combination;

/**
 * n个数进出栈的顺序有多少种？假设栈的容量无限大。
 *
 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
 *
 * 测试样例：
 * 1
 * 返回：1
 * @Author: Jeremy
 * @Date: 2019/6/3 17:15
 */
public class Stack {
    public int countWays(int n) {
        // write code here
        return (int)Combination.getCAB(2 * n, n) / (n + 1);
    }
}
