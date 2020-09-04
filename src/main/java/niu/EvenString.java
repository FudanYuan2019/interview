package niu;

import java.util.Scanner;

public class EvenString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLen = 0;
        int i = str.length() - 1;
        while (i >= 0) {
            String subStr = str.substring(0, i);
            int len = getMaxLen(subStr);
            if (len > maxLen){
                maxLen = len;
            }
            i--;
        }
        System.out.println(maxLen);
    }

    public static int getMaxLen(String string) {
        if (string.length() % 2 != 0) {
            return -1;
        }
        if (!isEvenString(string)) {
            return -1;
        }
        return string.length();
    }

    public static boolean isEvenString(String string) {
        boolean res = true;
        int len = string.length() >> 1;
        for (int i = 0; i < len; i++) {
            if (string.charAt(i) != string.charAt(i + len)) {
                return false;
            }
        }
        return res;
    }
}