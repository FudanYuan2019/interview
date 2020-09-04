package base.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jeremy
 * @Date: 2020/2/17 14:28
 */
public class LongestNotDuplicateSubString {
    public String find(String string){
        if (string == null || string.length() == 0){
            return null;
        }
        int maxLen = 0;
        int tempLen = 0;
        String maxStr = null;
        StringBuilder tempStr = new StringBuilder();
        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : string.toCharArray()){
            if (dict.containsKey(ch)){
                tempLen = 1;
                tempStr = new StringBuilder(String.valueOf(ch));
                dict = new HashMap<>();
                dict.put(ch, 1);
            } else {
                tempLen += 1;
                tempStr.append(ch);
                dict.put(ch, 1);
                maxStr = tempLen > maxLen ? tempStr.toString() : maxStr;
                maxLen = Math.max(tempLen, maxLen);
            }
            System.out.println(maxStr);
        }

        return maxStr;
    }


    public static void main(String[] args) {
        String string = "abaddaaabcde";
        System.out.println(new LongestNotDuplicateSubString().find(string));
    }
}
