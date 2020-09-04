package javalearning.object;

/**
 * @Author: Jeremy
 * @Date: 2019/5/22 17:18
 */
public class Singleton {
    private static Singleton instance;

    public final static int a = 10;
    public final int b;
    public int c;

    private Singleton(){
        getB();
        b = 10;
        System.out.println(b);
    }

    public void getB(){
        System.out.println(b);
    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args){
        Singleton s1 = Singleton.getInstance();
        final Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);

        s2.c = 10;

        final String str1 = "疯狂";
        final String str2 = "Java";
        final String str3 = str1 + str2;
        final String str4 = "疯狂" + "Java";
        System.out.println(str3 == str4);

        Integer a = new Integer(200);
        Integer b = Integer.valueOf(200);
        Integer c = Integer.valueOf(200);
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(b == c);
    }}