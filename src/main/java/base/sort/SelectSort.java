package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/11 12:17
 */
public class SelectSort {
    public int[] selectionSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[min] > A[j]) { // 寻找未排序中的最小值
                    min = j;
                }
            }

            int temp = A[min];
            A[min] = A[i];
            A[i] = temp;

        }
        return A;
    }
}
