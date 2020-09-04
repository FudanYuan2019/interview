package javalearning.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2019/5/21 11:18
 */
public class Wildcard {
    public static void test1 (List<?> list){
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
        for (Object ele : list){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    public static void test2(List<? extends String> list){
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
        for (String ele : list){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    public static void test3(List<? super Integer> list){
        list.add(13);
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i) + "\t");
        }
        System.out.println();
        for (Object ele : list){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }

    public static <T extends Number> void fromArrayToCollection(T[] a, List<T> b){
        for (T ele : a){
            b.add(ele);
        }
        for (T ele : b){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }


    public static <T> void fromArrayToCollection2(List<? extends T> a, List<T> b){
        for (T ele : a){
            b.add(ele);
        }
        for (Object ele : b){
            System.out.print(ele + "\t");
        }
        System.out.println();
    }
    public static void main(String[] args){
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        test1(list2);

        List<String> list1 = new ArrayList<String>();
        list1.add("4");
        list1.add("5");
        list1.add("6");
        test2(list1);

        List<Integer> list3 = new ArrayList<Integer>();
        list3.add(7);
        list3.add(8);
        list3.add(9);
        test3(list3);

        List<Number> list4 = new ArrayList<Number>();
        list4.add(10);
        list4.add(11);
        list4.add(12);
        test3(list4);

        Integer[] a = {21,22,23};
        List<Integer> b = new ArrayList<Integer>();
        fromArrayToCollection(a, b);
        System.out.println();

        // 编译错误
//        String[] c = {"21","22","23"};
//        List<String> d = new ArrayList<String>();
//        fromArrayToCollection(c, d);
//        System.out.println();

        List<String> c = new ArrayList<String>();
        c.add("31");
        c.add("32");
        c.add("33");
        List<String> d = new ArrayList<String>();
        fromArrayToCollection2(c, d);
        System.out.println();

        List<?>[] lsa = new ArrayList<?>[10];
        List<Integer> li = new ArrayList<Integer>();
        li.add(3);
        lsa[0] = li;
        System.out.println(lsa[0].get(0));
    }
}
