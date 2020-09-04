package base.probability;

import java.util.Arrays;

/**
 * n只蚂蚁从正n边形的n个定点沿着边移动，速度是相同的，问它们碰头的概率是多少？
 * <p>
 * 给定一个正整数n，请返回一个数组，其中两个元素分别为结果的分子和分母，请化为最简分数。
 * <p>
 * 测试样例：
 * 3
 * 返回：[3,4]
 *
 * @Author: Jeremy
 * @Date: 2019/5/30 16:43
 */
public class Ants {
    public int[] collision(int n) {
        // write code here
        // 总情况数为2^n
        int a = (int) Math.pow(2, n);
        // 不碰头的情况数为2，因此碰头情况数为2^n-2
        int b = a - 2;

        int c = this.gcd(b, a);

        return new int[]{b / c, a / c};
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
        Ants ants = new Ants();
        int[] res = ants.collision(3);
        System.out.println(Arrays.toString(res));

    }
}
