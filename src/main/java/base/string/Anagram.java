package base.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jeremy
 * @Date: 2019/11/15 16:10
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            int count = map.get(t.charAt(i));
            map.put(t.charAt(i), --count);
        }

        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return false;
            }
        }
        return true;
    }

    public String LeftRotateString(String str, int n) {
        if(str.length() == 0){
            return "";
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < n / 2; i++) {
            char ch = chars[i];
            chars[i] = chars[n - i - 1];
            chars[n - i - 1] = ch;
        }

        for (int i = n; i < (len - n) / 2 + n; i++) {
            char ch = chars[i];
            chars[i] = chars[len - i + n - 1];
            chars[len - i + n - 1] = ch;
        }

        for (int i = 0; i < len / 2; i++) {
            char ch = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = ch;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (char ch : chars){
            stringBuffer.append(ch);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("anagram", "nagaram"));
        System.out.println(97 - 'A');
        System.out.println(anagram.LeftRotateString("abcXYZdef", 3));
    }
}
