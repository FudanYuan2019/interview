package bilibili;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/4 16:29
 */
public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        char[] res = reverse(sentence.toCharArray());
        for (char ch : res) {
            System.out.print(ch);
        }
    }

    public static char[] reverse(char[] sentence) {
        if (sentence == null || sentence.length <= 1) {
            return sentence;
        }

        int left = 0;
        int right = 0;
        int n = sentence.length;
        while (right < n) {
            while (right < n && sentence[right] != ' ') {
                right++;
            }
            for (int i = left; i < left + ((right - left) >> 1); i++) {
                swap(sentence, i, right + left - i - 1);
            }
            left = ++right;
        }
        for (int i = 0; i < n / 2; i++) {
            swap(sentence, i, n - i - 1);
        }
        return sentence;
    }

    public static void swap(char[] sentence, int i, int j) {
        char tmp = sentence[i];
        sentence[i] = sentence[j];
        sentence[j] = tmp;
    }
}
