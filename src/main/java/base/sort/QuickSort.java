package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 17:00
 */

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] A = quickSort.quickSort(new int[]{3, 1, 2, 4, 6}, 5);
        System.out.println(Arrays.toString(A));
    }

    public int[] quickSort(int[] A, int n) {
        // write code here
        if (A == null || n < 2) {
            return A;
        }
        sort(A, 0, n - 1);
        return A;
    }

    public void sort(int[] A, int left, int right) {
        if (left > right) {
            return;
        }
        int i = left;
        int j = right;
        int base = A[left];
        while (i < j) {
            while (A[j] >= base && i < j) {
                j--;
            }

            if (i < j) {
                A[i] = A[j];
            }

            while (A[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                A[j] = A[i];
            }
        }
        A[i] = base;

        sort(A, left, i - 1);
        sort(A, i + 1, right);
    }
}