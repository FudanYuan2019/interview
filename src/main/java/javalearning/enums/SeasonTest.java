package javalearning.enums;

import sun.java2d.loops.ProcessPath;

import java.io.File;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2019/5/23 16:28
 */
public class SeasonTest {
    public static void main(String[] args) throws Exception{
        System.out.println(Season.SPRING.toString());
        Scanner sc = new Scanner(new File("/Users/Jeremy/Desktop/Program/Interview/src/main/resources/file.txt"));
        sc.useDelimiter("\t");
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        Map<String, String> env = System.getenv();
        for (String name : env.keySet()){
            System.out.println(name + "==>" + env.get(name));
        }

        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        String str1 = new String("hello");
        String str2 = new String("hello");
        System.out.println(System.identityHashCode(str1) + "  " + System.identityHashCode(str2));

        String st3 = "Hello";
        String st4 = "Hello";
        System.out.println(System.identityHashCode(st3) + "    " + System.identityHashCode(st4));

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.availableProcessors());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1");
        stringBuffer.append("2");
        System.out.println(stringBuffer.toString());


        System.out.println(0.05 + 0.01);

        BigDecimal b1 = new BigDecimal("0.01");
        BigDecimal b2 = new BigDecimal("0.05");
        System.out.println(b1.add(b2));

        BigDecimal b3 = BigDecimal.valueOf(0.05);
        System.out.println(b1.add(b3).doubleValue());

        Scanner scanner = new Scanner(System.in);
        // scanner.useDelimiter("\n");
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }


    }
}
