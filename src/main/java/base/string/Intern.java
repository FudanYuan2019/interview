package base.string;

/**
 * intern() 如果池已经包含一个等于此String对象的字符串（用equals(oject)方法确定），则返回池中的字符串。否则，将此String对象添加到池中，并返回此String对象的引用。
 * @Author: Jeremy
 * @Date: 2020/2/7 11:32
 */
public class Intern {
    public static void main(String[] args) {
        String s1 = new String("1"); // "1"在字符串常量池和堆上，但是s1指向的是堆上对象地址。
        String s3 = s1.intern();    // "1"存在于字符串常量池中，s3指向的是字符串常量池"1"的地址。
        String s2 = "1";    // s2指向的是字符串常量池"1"的地址，即与s3相等。
        System.out.println(s1 == s2);  // false
        System.out.println(s2 == s3);  // true
        System.out.println(s1 == s3);  // false

        System.out.println("======================");

        //第二种情况
        s3 = new String("1") + new String("1");  // s3 指向的是堆上"11"的对象地址，字符串常量池中并不存在"11"的字符串对象。
        String s5 = s3.intern();    // s3.intern() 会返回堆上"11"的对象引用。
        String s4 = "11";   // 字符串常量池中存在"11"，返回堆上"11"的对象引用。
        System.out.println(s3 == s4);   // true
        System.out.println(s3 == s5);   // true
        System.out.println(s4 == s5);   // true

        System.out.println("======================");

        // Create three strings in three different ways.
        s1 = "Hello";
        s2 = new StringBuffer("He").append("llo").toString();
        s3 = s2.intern();
        // Determine which strings are equivalent using the ==
        // operator
        System.out.println("s1 == s2? " + (s1 == s2));  // false
        System.out.println("s1 == s3? " + (s1 == s3));  // true
        System.out.println("s2 == s3? " + (s2 == s3));  // false

        System.out.println("======================");

        String m = "hello,world";
        String u = new String(m);
        String v = new String("hello,world");
        System.out.println(m == u);     // false
        System.out.println(u == v);     // false

        System.out.println("======================");

        //发现原来是在JVM启动的时候调用了一些方法，在常量池中已经生成了"java"字符串常量，
        s2 = new String("ja") + new String("va");
        s3 = s2.intern();
        s4 = "java";
        System.out.println(s2 == s3);   // false
        System.out.println(s3 == s4);   // true
    }
}
