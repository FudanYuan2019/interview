package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/18 21:12
 */
public class ScaleSort {
    public static void main(String args[]) {
        ScaleSort scaleSort = new ScaleSort();
        int[] A = new int[]{2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        int[] res = scaleSort.sortElement(A, 10, 2);
        for (int a : res) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public int[] sortElement(int[] A, int n, int k) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && j > i - k; j--) {
                if (A[j] < A[j - 1]) {
                    int tmp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = tmp;
                }
            }
        }
        return A;
    }
}
