package acm;

/**
 * 从10亿个数据中找出前1000大的数据
 * 解决方法有 排序、部分排序、分治、堆等
 * @Author: Jeremy
 * @Date: 2018/10/16 09:23
 */
public class TopN {
    public static void main(String args[]){
        TopN topN = new TopN();
        int[] ret = topN.topN(new int[]{6,3,5,1,7,8,9,12,3,2}, 8);
        for (int i : ret){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] topN(int[] arr, int N){
        int[] heap = new int[N];
        for (int i = 0; i < N; i++){
            heap[i] = arr[i];
        }
        adjustHeap(heap, N);

        for (int j = N; j < arr.length; j++){
            if (arr[j] > heap[0]){
                heap[0] = heap[N-1];
                heap[N-1] = arr[j];
                adjustHeap(heap, N);
            }
        }
        return heap;
    }

    public static int[] buildHeap(int[] arr, int i){
        int temp = arr[i]; // 寻找归宿
        for (int k = 2*i+1; k<arr.length; k=2*k+1){
            if (k+1 < arr.length && arr[k+1] < arr[k]){
                k++;
            }
            if (arr[k] < temp){  // 如果该节点值小于temp，交换
                arr[i] = arr[k];
                i = k;
            }
        }
        arr[i] = temp;  // 找到归宿
        return arr;
    }

    public void adjustHeap(int[] arr, int N){
        for (int i=N/2-1; i>=0; i--){
            buildHeap(arr, i);
        }
    }

    public static int[] swap(int[] A, int p1, int p2){
        int tmp = A[p1];
        A[p1] = A[p2];
        A[p2] = tmp;
        return A;
    }
}
