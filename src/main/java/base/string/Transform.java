package base.string;

/**
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * @Author: Jeremy
 * @Date: 2018/10/19 16:33
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 解决思路：
 * 哈希
 */
public class Transform {
    public static void main(String args[]){
        System.out.println(new Transform().chkTransform("abc",3,"bca",3));
    }
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int i = 0;
        int j = 0;
        char[] str1 = A.toCharArray();
        char[] str2 = B.toCharArray();
        while (i < lena){
            char a = str1[i];
            if (!hashMap.containsKey(a)){
                hashMap.put(a, 0);
            }
            hashMap.put(a, hashMap.get(a)+1);
            i++;
        }

        while (j < lenb){
            char b = str2[j];
            if (!hashMap.containsKey(b)){
                return false;
            } else {
                hashMap.put(b, hashMap.get(b)-1);
            }
            j++;
        }

        for (char key : hashMap.keySet()){
            if (hashMap.get(key) != 0){
                return false;
            }
        }
        return true;
    }
}
