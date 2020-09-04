package javalearning.object;

import java.util.Calendar;

/**
 * @Author: Jeremy
 * @Date: 2019/5/23 21:08
 */
public class CalendarTest {
    public static String output = "";

    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }

    public void fun() {

    }

    public static void test() {
        CalendarTest calendarTest = new CalendarTest();
        calendarTest.fun();
    }


    private static int j = 0;

    private static Boolean methodB(int k) {
        j += k;
        return true;
    }

    public static void methodA(int i) {
        boolean b;
        b = i < 10 | methodB(4);
        b = i < 10 || methodB(8);

    }

    public static void main(String[] args) {
        test();
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH) + 1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.HOUR));
        System.out.println(calendar.getTime());
        calendar.add(Calendar.HOUR, 1);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 8);
        System.out.println(calendar.getTime());

//        int x=20, y=30;
//        boolean b;
//        b = x > 50 && y > 60 || x > 50 && y < -60 || x < -50 && y > 60 || x < -50 && y < -60;
//        System.out.println(b);

//        String x="fmn";
//        x.toUpperCase();
//        String y=x.replace('f','F');
//        y=y+"wxy";
//        System.out.println(y);
//
//        methodA(0);
//        System.out.println(j);
//
//        Integer i01 = 59;
//        int i02 = 59;
//        Integer i03 =Integer.valueOf(59);
//        Integer i04 = new Integer(59);
//        System.out.println(i03 == i04);


        Integer i = 42;
        Long l = 42L;
        Double d = 42.0;
        System.out.println(l.equals(42L));

        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s == t);
        System.out.println(System.identityHashCode(s) + " " + System.identityHashCode(t));
        System.out.println(s.equals(c));
    }
}
