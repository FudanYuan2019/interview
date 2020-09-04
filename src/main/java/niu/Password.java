package niu;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/24 18:13
 */
public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        String string = sc.next();
        double res = n;
        for (int i = 0; i < string.length(); i++) {
            char op = string.charAt(i);
            int j = i + 1;
            while (j < string.length()) {
                if (string.charAt(j) >= 48 && string.charAt(j) <= 57) {
                    j++;
                } else {
                    break;
                }
            }
            double num = Double.parseDouble(string.substring(i + 1, j));
            if (op == '*') {
                res *= num;
            }
            if (op == '/') {
                res /= num;
            }
            if (op == '+') {
                res += num;
            }
            if (op == '-') {
                res -= num;
            }
            if (op == '%') {
                res %= num;
            }
            if (op == '^') {
                res = Math.pow(res, num);
            }

            i = j - 1;
        }
        System.out.println(String.format("%.0f", Math.abs(res)));
    }
}
