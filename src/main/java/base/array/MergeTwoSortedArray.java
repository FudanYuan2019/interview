package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 15:50
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        MergeTwoSortedArray merge = new MergeTwoSortedArray();
        int[] A = new int[]{4, 5, 6, 8};
        int[] B = new int[]{1, 2, 3, 6};
        int[] C = merge.merge(A, B);
        for (int c : C) {
            System.out.print(c + " ");
        }
    }

    public int[] merge(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[] C = new int[lenA + lenB];
        int i = 0;
        int j = 0;
        int m = 0;
        while (i < lenA && j < lenB) {
            if (A[i] <= B[j]) {
                C[m++] = A[i++];
            } else {
                C[m++] = B[j++];
            }
        }
        while (i < lenA) {
            C[m++] = A[i++];
        }

        while (j < lenB) {
            C[m++] = B[j++];
        }
        return C;
    }
}
