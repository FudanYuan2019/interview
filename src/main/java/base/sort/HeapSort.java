package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 19:04
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] A = heapSort.heapSort(new int[]{2, 6, 3, 5, 7, 4, 1,}, 7);
        for (int a : A) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public int[] heapSort(int[] arr, int n) {
        for (int i = n / 2; i >= 0; i--) {
            adjustHeap(arr, n - 1, i);
        }
        int k = n - 1;
        while (k > 0) {
            swap(arr, k, 0);
            adjustHeap(arr, --k, 0);
        }
        return arr;
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     *
     * @param arr
     * @param length
     * @param i
     */
    public static void adjustHeap(int[] arr, int length, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i + 1 <= length && arr[i] < arr[i * 2 + 1]) maxPos = i * 2 + 1;
            if (2 * i + 2 <= length && arr[maxPos] < arr[i * 2 + 2]) maxPos = i * 2 + 2;
            if (maxPos == i) break;
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    public static int[] swap(int[] A, int p1, int p2) {
        int tmp = A[p1];
        A[p1] = A[p2];
        A[p2] = tmp;
        return A;
    }
}
