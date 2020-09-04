package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/9 23:09
 */

public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        for (int i = n; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int tmp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return A;
    }
}