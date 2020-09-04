package niu;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/24 21:16
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        if (sc.hasNextLine()){
//            float[] array = new float[2];
//            String[] strings = sc.nextLine().split(" ");
//            int i = 0;
//            for (String s : strings){
//                array[i++] = Float.valueOf(s);
//            }
//            System.out.println(String.format("%.3f", array[0] / array[1]));
//        }
//        String[] strings;
//        int n = sc.nextInt();
//        strings = new String[n * 2];
//        for (int i = 0; i < 2 * n; i++) {
//            strings[i] = sc.next();
//        }

//        for (int i = 0; i < strings.length >> 2; i++) {
//            System.out.println(i);
//            String str1 = strings[i * 2];
//            String str2 = strings[i * 2 + 1];
//            String[] time1 = str1.split("\\D+");
//            String[] time2 = str2.split("\\D+");
//            int[] tmp = new int[]{3600 * 24, 3600, 60, 1};
//            long ans = 0;
//            for (int j = 0; j < 4; j++) {
//                ans += (Long.parseLong(time2[j]) - Long.parseLong(time1[j])) * tmp[j];
//            }
//            System.out.println(ans);
//        }

        ArrayList<Integer> list = new ArrayList<>();
        int counter = 0;
        while (counter < 2) {
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            counter++;
        }

        int ans = (list.get(3) -  list.get(1)) + (list.get(2) -  list.get(0)) * 60;
        System.out.println(ans);
    }
}
