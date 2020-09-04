package javalearning.regex;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Jeremy
 * @Date: 2019/5/26 13:55
 */
public class GroupTest {
    public static Pattern p1 = Pattern.compile("CD");
    public static Pattern p2 = Pattern.compile("B");
    public static Pattern p3 = Pattern.compile("F");
    public static void func1(){
        String string = "ABCDEFG";
        Matcher matcher = p1.matcher(string);
        while (matcher.find()){
            System.out.println(matcher.group() + " " + matcher.start() + " " + matcher.end());
            System.out.println(matcher.replaceAll(""));
        }
    }

    public static void func2(){
        String s = "A1B2C3D4";
        String[] s1 = s.split("\\d");
        System.out.println(Arrays.toString(s1));
        String[] s2 = s.split("[A-D]");
        List<Integer> list = new ArrayList<>();
        for (String c : s2){
            if ("".equals(c)){
                continue;
            }
            int i = 0;
            try {
                i = Integer.parseInt(c);
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
            list.add(Integer.valueOf(i));
        }
        int[] ans = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) throws Exception{
//        func2();
//        System.out.println( new String("ISO8859-1".getBytes("ISO8859-1"),"GB2312"));
        int Arry_a[] = new int[10];
        System.out.println(Arry_a[10]);
    }
}
