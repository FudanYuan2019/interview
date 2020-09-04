package niu;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: Jeremy
 * @Date: 2020/8/28 14:27
 */
public class Main {
    public static void main(String[] args) {

        String[][] s = {{"helloworld", "hello world"}, {"this is", "a java program"}};

        System.out.println((new StringTokenizer(s[1][1])).countTokens() > 2);

        System.out.println(strStr("helloworld", "llo"));

        List<List<Integer>> res = subsets(new int[]{1, 2, 3});
        for (List<Integer> list : res) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }

        if (needle == null || "".equals(needle)) {
            return 0;
        }

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();

        int count = (int) Math.pow(2, nums.length);
        for (int i = 0; i < count; i++) {
            int[] list = transform(i, nums.length);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < list.length; j++) {
                if (list[j] != 0) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static int[] transform(int num, int size) {
        int[] res = new int[size];
        int count = 0;
        while (num > 0) {
            res[size - 1 - count++] = num % 2;
            num /= 2;
        }
        return res;
    }
}
