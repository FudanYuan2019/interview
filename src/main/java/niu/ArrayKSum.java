package niu;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/24 18:49
 */
public class ArrayKSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] p = new int[3];
        int counter = 0;
        String[] strings = scanner.nextLine().split(" ");
        for (String s : strings) {
            p[counter++] = Integer.parseInt(s);
        }
        int n = p[0];
        int m = p[1];
        int k = p[2];

        int[] array = new int[n];
        counter = 0;
        strings = scanner.nextLine().split(" ");
        for (String s : strings) {
            array[counter++] = Integer.parseInt(s);
        }

        int result = 0;
        for (int i = 0; i < n - m + 1; i++) {
            int[] tmp = new int[m];
            System.arraycopy(array, i, tmp, 0, m);
            Arrays.sort(tmp, 0, m);
            for (int t : tmp) {
            }
            for (int j = 0; j < k; j++){
                result += tmp[j];
            }
        }
        System.out.println(result);
    }
}
