package base.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2019/11/29 15:29
 */
public class LongestDuplicateSubstring {
    /*
    Rabin-Karp with polynomial rolling hash.
    Search a substring of given length
    that occurs at least 2 times.
    Return start position if the substring exits and -1 otherwise.
    */
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) h = (h * a + nums[i]) % modulus;

        // already seen hashes of strings of length L
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        // const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) aL = (aL * a) % modulus;

        for (int start = 1; start < n - L + 1; ++start) {
            // compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (seen.contains(h)) return start;
            seen.add(h);
        }
        return -1;
    }

    public String longestDupSubstring(String S) {
        int n = S.length();
        // convert string to array of integers
        // to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) nums[i] = (int) S.charAt(i) - (int) 'a';
        // base value for the rolling hash function
        int a = 26;
        // modulus value for the rolling hash function to avoid overflow
        long modulus = (long) Math.pow(2, 32);

        // binary search, L = repeating string length
        int left = 1, right = n;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search(L, a, modulus, n, nums) != -1) left = L + 1;
            else right = L;
        }

        int start = search(left - 1, a, modulus, n, nums);
        return start != -1 ? S.substring(start, start + left - 1) : "";
    }

    public static int longestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        List<Character> list = new ArrayList<>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                int index = list.indexOf(s.charAt(i));
                list = list.subList(index + 1, list.size());
                list.add(s.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            } else {
                list.add(s.charAt(i));
                maxLength = Math.max(maxLength, list.size());
            }
        }
        for (char character : list) {
            System.out.println(character);
        }
        System.out.println(list.size());
        return maxLength;
    }

    public int[] maxRepat(int[] input) {
        if(input == null || input.length == 0){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int k = Integer.MIN_VALUE;
        int first = 0;
        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input.length - i; j++) {
                if(input[j] == input[i + j]){
                    k++;
                }else{
                    k = 0;
                }

                if(k > max){
                    max = k;
                    first = j - k + 1;
                }
            }
        }

        return Arrays.copyOfRange(input, first, first + max);
    }

    public List<Integer> longestSubsequence(int[] array) {
        List<Integer> list = new ArrayList<>();
        if (array.length == 0) {
            return list;
        }
        int maxLength = 1;
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (list.contains(array[i])) {
                int index = list.indexOf(array[i]);
                list = list.subList(index + 1, list.size());
                list.add(array[i]);
                maxLength = Math.max(maxLength, list.size());
            } else {
                list.add(array[i]);
                maxLength = Math.max(maxLength, list.size());
            }
        }
        for (int num : list) {
            System.out.println(num);
        }
        System.out.println(list.size());
        return list;
    }

    public static void main(String[] args) {
        String input = "155 156 142 143 158 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102 103 104 99 100 101 102";
        LongestDuplicateSubstring longestDuplicateSubstring = new LongestDuplicateSubstring();
        String s = longestDuplicateSubstring.longestDupSubstring(input);
        System.out.println(s);

        int[] inputSeq = {103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104};
        List<Integer> res = longestDuplicateSubstring.longestSubsequence(inputSeq);

        int[] inputSeq2 = {103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104, 99, 100, 101, 102, 103, 104};
        int[] repeat = longestDuplicateSubstring.maxRepat(inputSeq2);
        System.out.println(Arrays.toString(repeat));
    }
}
