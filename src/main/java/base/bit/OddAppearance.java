package base.bit;

import java.util.Arrays;

/**
 * 有一个整型数组A，其中N个数出现了奇数次，其他的数都出现了偶数次，
 * 请打印这个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。
 * <p>
 * 给定整形数组A及它的大小n，请返回题目所求数字。
 * <p>
 * 测试样例：
 * [1,2,3,2,1],5
 * 返回：3
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 15:05
 */
public class OddAppearance {
    /**
     * N = 1
     *
     * @param A
     * @param n
     * @return
     */
    public int findOdd(int[] A, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = A[i] ^ res;
        }
        return res;
    }

    /**
     * N = 2
     *
     * @param A
     * @param n
     * @return
     */
    public int[] findOdds(int[] A, int n) {
        int[] res = new int[2];
        int e0 = 0;
        for (int i = 0; i < n; i++) {
            e0 ^= A[i];
        }
        System.out.println(e0);
        int rightOne = e0 & (~e0 + 1);
        int e1 = 0;
        for (int i = 0; i < n; i++) {
            if ((A[i] & rightOne) != 0) {
                e1 ^= A[i];
            }
        }

        res[0] = Math.min(e1, e0 ^ e1);
        res[1] = Math.max(e1, e0 ^ e1);
        return res;
    }

    public static void main(String[] args) {
        OddAppearance oddAppearance = new OddAppearance();
        int[] A = new int[]{1, 2, 3, 2, 1};
        System.out.println(oddAppearance.findOdd(A, A.length));

        int[] B = new int[]{1, 2, 4, 4, 2, 1, 3, 5};
        System.out.println(Arrays.toString(oddAppearance.findOdds(B, B.length)));
    }
}
