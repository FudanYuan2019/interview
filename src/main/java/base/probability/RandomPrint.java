package base.probability;

import java.util.Arrays;
import java.util.Random;

/**
 * 给定一个长度为N且没有重复元素的数组arr和一个整数M，实现函数等概率随机打印arr中的M个数。
 *
 * @Author: Jeremy
 * @Date: 2019/5/30 18:17
 */
public class RandomPrint {
    public static Random random = new Random(123456);

    public int[] print(int[] arr, int N, int M) {
        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            int index = random.nextInt(N - i - 1);
            res[i] = arr[index];
            int tmp = arr[index];
            arr[index] = arr[N - i - 1];
            arr[N - i - 1] = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomPrint randomPrint = new RandomPrint();

        int[] arr = new int[]{1, 2, 5};
        int M = 2;
        int[] res = randomPrint.print(arr, arr.length, M);
        System.out.println(Arrays.toString(res));
    }
}
