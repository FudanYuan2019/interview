package base.sort;

import base.array.MergeTwoSortedArray;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 16:14
 */
public class MergeSort {
    public static void main(String args[]) {
        MergeSort mergeSort = new MergeSort();
        int[] result = mergeSort.mergeSort(new int[]{54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28}, 13);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }

    public int[] mergeSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }

        if (n == 2) {
            if (A[0] > A[1]) {
                int a = A[0];
                A[0] = A[1];
                A[1] = a;
            }
            return A;
        }
        int left = 0;
        int right = n;
        int mid = (left + right) / 2;
        int[] leftA = new int[mid];
        int[] rightA = new int[right - mid];
        int i = 0;
        int j = mid;
        while (i < mid) {
            leftA[i] = A[i++];
        }
        while (j < right) {
            rightA[j - mid] = A[j++];
        }
        leftA = mergeSort(leftA, leftA.length);
        rightA = mergeSort(rightA, rightA.length);
        return new MergeTwoSortedArray().merge(leftA, rightA);
    }
}
