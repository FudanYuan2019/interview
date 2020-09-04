package pin;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/31 17:17
 */
public class PaiLie {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();

            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                if (num % 4 == 0) {
                    System.out.println("0 " + num);
                } else if (num % 4 == 1) {
                    System.out.println("1 " + num);
                } else if (num % 4 == 2) {
                    System.out.println("1 " + (num - 1));
                } else if (num % 4 == 3) {
                    System.out.println("0 " + (num - 1));
                }
            }
        }
    }
}
