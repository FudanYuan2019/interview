package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/18 22:31
 */
public class Subsequence {
    public static void main(String args[]){
        Subsequence subsequence = new Subsequence();
        int[] A = new int[]{0,1,1,0,2,2};
        int a = subsequence.shortestSubsequence(A, 6);
        System.out.print(a + " ");
    }
    public int shortestSubsequence(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[n-1];
        int l = 0;
        int r = 0;
        for(int i=0; i<n; i++){
            if (A[i] > max){
                max = A[i];
            }
            if(A[i] < max){
                r = i;
            }
        }
        for(int i=n-1; i>=0; i--){
            if (A[i] < min){
                min = A[i];
            }
            if(A[i] > min){
                l = i;
            }
        }
        if (r-l == 0) return 0;
        else return r-l+1;
    }
}
