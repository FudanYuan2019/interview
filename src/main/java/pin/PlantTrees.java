package pin;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/1 15:57
 */
public class PlantTrees {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        int M = 0;
        for (int i = 0; i < N; i++) {
            A[i] = in.nextInt();
            M += A[i];
        }
        int[] res = new int[M];
        res[0] = 1;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            if (i == 1) {
                sum++;
            }
            for (int j = 1; j < M; j++) {
                if (sum < A[i-1] && res[j] == 0 && res[j - 1] != i) {
                    res[j] = i;
                    sum++;
                }
            }
            if (sum != A[i - 1]) {
                System.out.println("-");
                return;
            }
        }
        for (int i = 0; i < M; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
