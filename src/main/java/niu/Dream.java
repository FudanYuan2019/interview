package niu;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/24 19:27
 */
public class Dream {
    private static int ans2 = 0;

    public static void hanoi(int n, char start, char by, char end) {
        ans2 += 1;
        if (n == 1) {
            //System.out.println(n + " " + start + " by " + by + " to " + end);
        } else {
            hanoi(n - 1, start, end, by);
            //System.out.println(n + " " + start + " by " + by + " to " + end);
            hanoi(n - 1, by, start, end);
        }
    }

    public static void main(String[] args) {
        List Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
        Scanner sc = new Scanner(System.in);
        int[] p = new int[3];
        int counter = 0;
        String[] strings = sc.nextLine().split(" ");
        for (String s : strings) {
            p[counter++] = Integer.parseInt(s);
        }
        int n = p[0];
        int L = p[1];

        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            BigDecimal a = BigDecimal.valueOf(i * Math.log10(2));
            //System.out.println("a = " + a);
            BigDecimal b = BigDecimal.valueOf((int) (a.doubleValue()));
            //System.out.println("b = " + b);
            double c = a.subtract(b).doubleValue();
            //System.out.println("c = " + c);
            int d = (int) Math.pow(10, c);
            //System.out.println("d = " + d);
            if (d == L) {
                ans1 += 1;
            }
        }
        System.out.println(ans1);

        hanoi(2 * ans1, 'A', 'B', 'C');
        System.out.println(ans2);
    }
}
