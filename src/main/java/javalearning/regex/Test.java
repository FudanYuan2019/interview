package javalearning.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: Jeremy
 * @Date: 2019/5/26 11:16
 */
public class Test {
    private static Pattern p = Pattern.compile("a*b");
    public String str="6";
    public static void main(String[] args) {
        Test sv=new Test();
        sv.change(sv);
        System.out.println(sv.str);
    }
    public void change(Test test) {
        test.str="10";
    }
//    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()){
//            String in = scanner.nextLine();
//            // 匹配如le、lie、like、l9e、l_e形式的字符串
//            System.out.println(in.matches("l(\\w)*e"));
//            // 匹配如000-000-0000形式的电话号码
//            System.out.println(in.matches("((\\d){3}-){2}(\\d){4}"));
//
//            // 方括号表达式：[]
//            // 枚举——匹配a、b、 c中任意一个字符
//            System.out.println(in.matches("[abc]"));
//            // 表示范围——匹配a-f中的任意一个字符
//            System.out.println(in.matches("[a-fx-z]"));
//
//            Matcher m = p.matcher("aaaaaab");
//            boolean res = m.matches();
//            System.out.println(res);
//        }
//    }
}
