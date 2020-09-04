package base.probability;

import java.util.Arrays;

/**
 * 有2k只球队，有k-1个强队，其余都是弱队，随机把它们分成k组比赛，
 * 每组两个队，问两强相遇的概率是多大？
 * <p>
 * 给定一个数k，请返回一个数组，其中有两个元素，分别为最终结果的分子和分母，请化成最简分数
 * <p>
 * 测试样例：
 * 4
 * 返回：[3,7]
 *
 * @Author: Jeremy
 * @Date: 2019/5/30 16:11
 */
public class Championship {
    public int[] calc(int k) {
        // write code here
        int a = 1, b = 1;
        // 总的情况为：(2k-1) * (2k-3) * (2k-5) * ... * 1
        for (int i = 2 * k - 1; i >= 1; i -= 2) {
            a *= i;
        }
        // 两强队不相遇的情况为：C(k+1, k-1) * (k-1)! = (k+1)! / 2
        for (int i = 1; i <= k + 1; i++) {
            b *= i;
        }
        b /= 2;

        // 两强队相遇情况为 a - b
        b = a - b;

        // 使用辗转相除法化简
        int d = this.gcd(b, a);

        // 返回结果
        int[] ret = new int[2];
        ret[0] = b / d;
        ret[1] = a / d;
        return ret;
    }

    public int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) {
        Championship championship = new Championship();
        int[] res = championship.calc(4);
        System.out.println(Arrays.toString(res));

    }
}
