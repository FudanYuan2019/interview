package pin;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/31 16:37
 */
public class MagicBox {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                System.out.println((int) Math.floor(Math.log(num) / Math.log(2)) + 1);
            }
        }
    }
}
