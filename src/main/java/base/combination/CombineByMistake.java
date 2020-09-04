package base.combination;

import java.math.BigInteger;

/**
 * 有n个信封，包含n封信，现在把信拿出来，再装回去，要求每封信不能装回它原来的信封，
 * 问有多少种装法?
 * <p>
 * 给定一个整数n，请返回装发个数，为了防止溢出，
 * 请返回结果Mod 1000000007的值。
 * 保证n的大小小于等于300。
 * <p>
 * 测试样例：
 * 2
 * 返回：1
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 18:12
 */
public class CombineByMistake {
    public int countWays(int n) {
        // write code here
        if (n <= 0) {
            return -1;
        }
        if (n <= 2) {
            return n - 1;
        }
        long res = 1;
        long lastLast = 0;
        long last = 1;
        for (int i = 3; i <= n; i++) {
            long cur = ((i - 1) * (last + lastLast) % 1000000007) % 1000000007;
            res = cur;
            lastLast = last;
            last = cur;
        }
        return (int)res % 1000000007;
    }

    public static void main(String[] args) {
        System.out.println(new CombineByMistake().countWays(4));
    }
}
