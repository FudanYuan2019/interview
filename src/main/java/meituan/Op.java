package meituan;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/29 17:36
 */
public class Op {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            int[] A = new int[len];
            int[] B = new int[len];

            in.nextLine();
            String[] strings = in.nextLine().split(" ");
            for (int i = 0; i < len; i++) {
                A[i] = Integer.parseInt(strings[i]);
                B[i] = -1;
            }

            int ops = in.nextInt();
            in.nextLine();
            for (int i = 0; i < ops; i++) {
                String[] spStr = in.nextLine().split(" ");
                if ("1".equals(spStr[0])) {
                    int k = Integer.parseInt(spStr[1]);
                    int x = Integer.parseInt(spStr[2]);
                    int y = Integer.parseInt(spStr[3]);
                    copy(A, B, k, x, y);

                } else if ("2".equals(spStr[0])) {
                    int x = Integer.parseInt(spStr[1]);
                    query(B, x);
                }
            }
        }
    }

    public static void copy(int[] A, int[] B, int k, int x, int y) {
        for (int i = 0; i < k; i++) {
            B[y + i - 1] = A[x + i - 1];
        }
    }

    public static void query(int[] B, int index) {
        System.out.println(B[index - 1]);
    }
}
