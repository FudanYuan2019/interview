package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/12 20:03
 */
public class ShellSort {
    public static void main(String args[]){
        ShellSort shellSort = new ShellSort();
       int[] A = shellSort.shellSort(new int[]{4, 6, 8, 5, 9}, 5);
        for (int a : A){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public int[] shellSort(int[] A, int n) {
        // write code  here
        for (int step=n/2; step>0; step += step/2){
            for (int i = step; i<n; i++){
                int j = i;
                while (j >= step && A[j] < A[j-step]){
                    swap(A, j, j-step);
                    j -= step;
                }
            }
        }

        return A;
    }

    public static int[] swap(int[] A, int p1, int p2){
        int tmp = A[p1];
        A[p1] = A[p2];
        A[p2] = tmp;
        return A;
    }
}
