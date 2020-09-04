package javalearning.object;

/**
 * @Author: Jeremy
 * @Date: 2019/5/22 16:00
 */
public class EqualTest {
    public static void main(String[] args){
        int a = 65;
        float b = 65.0f;
        System.out.println(a == b);

        char c = 'A';
        System.out.println(a == c);

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(str1 == str2);

        System.out.println(str1.equals(str2));

        String str3 = str1 + str2;
        System.out.println(str3);

        String str4 = "hel";
        String str5 = "lo";
        String str6 = str4 + str5;
        System.out.println(str6);

        System.out.println(str1 == str6);
        System.out.println(str1.equals(str6));

        if (str1.getClass() == String.class){
            System.out.println(true);
        }
    }
}

