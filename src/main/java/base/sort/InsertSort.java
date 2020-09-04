package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/11 12:29
 */
public class InsertSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        for (int i = 0; i < n; i++) {
            int value = A[i];
            int j = i;
            for (; j > 0; j--) {
                // 移动数据
                if (value < A[j - 1]) {
                    A[j] = A[j - 1];
                } else {
                    break;
                }
            }
            // 插入数据
            A[j] = value;
        }
        return A;
    }
}
