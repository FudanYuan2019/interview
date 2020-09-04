package binaryDance;

import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2019/5/17 19:51
 */
public class Main {
    public static String getCorrectString(String word) {
        int flag1 = 0;
        int flag2 = 0;
        char[] result = new char[word.length()];
        int counter = 0;
        result[counter++] = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            char ch1 = word.charAt(i - 1);
            char ch2 = word.charAt(i);

            if (ch1 == ch2) {
                flag1 += 1;
            } else {
                flag1 = 0;
            }

            //System.out.println(ch1 + " " + ch2 + " " + flag1 + " " + flag2);
            if (flag1 == 1) {
                flag2 += 1;
            }

            if (flag1 == 2) {
                flag1 -= 1;
                continue;
            }
            if (flag2 == 2) {
                flag1 = 0;
                flag2 = 0;
                continue;
            }
            result[counter++] = ch2;
        }
        return String.valueOf(result);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            String word = scanner.nextLine();
            String result = getCorrectString(word);
            System.out.println(result);
        }
    }
}
