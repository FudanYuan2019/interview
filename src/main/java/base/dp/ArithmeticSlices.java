package base.dp;

/**
 * @Author: Jeremy
 * @Date: 2019/12/10 20:01
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int d = A[i + 1] - A[i];
            for (int j = i + 2; j < A.length; j++) {
                if (d == A[j] - A[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlicesDP(int[] A) {
        int count = 0;
        int[] dp = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                count += dp[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(A));
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlicesDP(A));
    }
}
