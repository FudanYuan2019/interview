package meituan;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/29 16:49
 */
public class Moqi {
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
            for (int i = 0; i < ops; i++) {
                String[] spStr = in.nextLine().split(" ");
                if ("1".equals(spStr[0])) {
                    int k = Integer.parseInt(spStr[1]);
                    int x = Integer.parseInt(spStr[2]);
                    int y = Integer.parseInt(spStr[3]);
                    System.out.println(k + " " + x + " " + y);

                } else if ("2".equals(spStr[0])) {
                    int x = Integer.parseInt(spStr[2]);
                    System.out.println(x);
                }
            }
        }
    }
}
