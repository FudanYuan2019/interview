package base.array;

import java.util.Arrays;

/**
 * @Author: Jeremy
 * @Date: 2019/11/26 10:19
 */
public class Permutation {
    // k表示要处理的子数组的数据个数
    public void printPermutations(int[] data, int n, int k) {
        if (k == 1){
            System.out.println(Arrays.toString(data));
        }
        for (int i = 0; i < k; i++){
            swap(data, i, k - 1);
            printPermutations(data, n, k - 1);
            swap(data, i, k - 1);
        }
    }

    public void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        int[]a = {1, 2, 3, 4};
        new Permutation().printPermutations(a, 4, 4);
    }
}
