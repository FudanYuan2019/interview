package meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Jeremy
 * @Date: 2020/8/29 16:25
 */
public class TaskDispatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            in.nextLine();
            int[][] arr = new int[len][len];
            for (int i = 0; i < len; i++) {
                String[] business = in.nextLine().split(" ");
                for (int j = 0; j < len; j++) {
                    arr[i][j] = Integer.parseInt(business[j]);
                }
            }

            int[] res = new int[len];
            Set<Integer> choosed = new HashSet<>(len);
            res[0] = arr[0][0];
            choosed.add(arr[0][0]);
            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= i; j++) {
                    if (!choosed.contains(arr[i][j])) {
                        res[i] = arr[i][j];
                        choosed.add(arr[i][j]);
                        break;
                    }
                }
            }

            for (int i = 0; i < len; i++) {
                System.out.print(res[i] + " ");
            }
        }
    }
}
