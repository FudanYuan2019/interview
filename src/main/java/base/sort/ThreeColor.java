package base.sort;

/**
 * @Author: Jeremy
 * @Date: 2018/10/18 22:15
 */
public class ThreeColor {
    public static void main(String args[]) {
        ThreeColor threeColor = new ThreeColor();
        int[] A = new int[]{2, 1, 0, 0, 1, 1, 0, 2, 2, 1, 2};
        int[] res = threeColor.sortThreeColor(A, A.length);
        for (int a : res) {
            System.out.print(a + " ");
        }

        System.out.println();
    }

    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        int left = -1;
        int right = n;
        int i = 0;
        while(i < right){
            int cur = A[i];
            if (cur == 0){
                int temp = A[++left];
                A[left] = cur;
                A[i++] = temp;
            } else if (cur == 2){
                int temp = A[--right];
                A[right] = cur;
                A[i] = temp;
            } else {
                i++;
            }
        }
        return A;
    }


}
