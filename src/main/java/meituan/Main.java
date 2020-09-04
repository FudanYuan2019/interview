package meituan;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/8/29 16:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            in.nextLine();
            String str = in.nextLine();
            // 从前往后获取 T 的位置
            int indexOfT = str.indexOf("T");
            boolean flagFront = false;
            while (indexOfT < len) {
                for (int i = 0; i < indexOfT; i++) {
                    if (str.charAt(i) == 'M') {
                        flagFront = true;
                        break;
                    }
                }
                if (flagFront) {
                    break;
                }
                indexOfT = str.indexOf("T", indexOfT);
            }

            // 从后往前获取 M 的位置。
            int indexOfM = str.lastIndexOf("M");
            boolean flagBack = false;
            while (indexOfM < len) {
                for (int i = indexOfM; i < len; i++) {
                    if (str.charAt(i) == 'T') {
                        flagBack = true;
                        break;
                    }
                }
                if (flagBack) {
                    break;
                }
                indexOfM = str.substring(0, indexOfM).lastIndexOf("M");
            }
            System.out.println(str.substring(indexOfT + 1, indexOfM));
        }
    }
}
