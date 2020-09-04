package base.binarysearch;

import java.math.BigInteger;

/**
 * 如果更快的求一个整数k的n次方。
 * 如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * <p>
 * 给定k和n，请返回k的n次方，为了防止溢出，请返回结果Mod 1000000007的值。
 * <p>
 * 测试样例：
 * 2,3
 * <p>
 * 返回：8
 *
 * @Author: Jeremy
 * @Date: 2019/6/1 16:33
 */
public class QuickPower {
    public int getPower(int k, int n) {
        BigInteger res = BigInteger.valueOf(1);
        BigInteger tmp = BigInteger.valueOf(k);
        for (; n != 0; n >>= 1) {
            if ((n & 1) != 0) {
                res = res.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
            tmp = tmp.mod(BigInteger.valueOf(1000000007));
            res = res.mod(BigInteger.valueOf(1000000007));
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        QuickPower quickPower = new QuickPower();
        int res = quickPower.getPower(2, 3);
        System.out.println(res);
    }
}
