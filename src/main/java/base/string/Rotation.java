package base.string;

/**
 * @Author: Jeremy
 * @Date: 2018/10/9 22:06
 */
import java.util.*;
import acm.KMP;

public class Rotation {

    public static void main(String args[]){
        Rotation rotation = new Rotation();
//        boolean result = rotation.chkRotation("cdab",4,"abcd",4);
//        System.out.println(result);

        System.out.println(rotation.traverse("abcd"));
        System.out.println(rotation.LeftRotateString("abcXYZdef", 9));
    }

    public boolean chkRotation(String A, int lena, String B, int lenb) {
        // 两字符串不等长，直接返回false
        if (lena != lenb){
            return false;
        }
        String AA = A + A;
        return KMP.KMP(AA, B);
    }

    /**
     * 转置字符串
     * @param string
     * @return
     */
    public String traverse(String string){
        int len = string.length();
        char[] chars = string.toCharArray();
        for (int i = 0; i < len / 2; i++){
            char temp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = temp;
        }
        return String.valueOf(chars);
    }

    public String LeftRotateString(String str, int n) {
        if (str == ""){
            return "";
        }
        if (n >= str.length()){
            return str;
        }
        String str1 = str.substring(0, n);
        String str2 = str.substring(n);
        str1 = traverse(str1);
        str2 = traverse(str2);
        str = traverse(str1 + str2);
        return str;
    }
}