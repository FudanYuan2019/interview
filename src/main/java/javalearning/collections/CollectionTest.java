package javalearning.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Author: Jeremy
 * @Date: 2019/5/27 15:24
 */
public class CollectionTest {
    static boolean flag;
    public static void main(String[] args){
        System.out.println(flag);

        Collection c = new ArrayList();
        c.add("孙悟空");
        c.add(6);
        System.out.println(c.size());

        c.remove(6);
        System.out.println(c.size());

        System.out.println(c.contains("孙悟空"));

        System.out.println(c);

        c = new HashSet();
        c.add("Java");
        c.add("JavaScript");
        System.out.println(c.size());

        c.remove("Java");
        System.out.println(c.size());

        System.out.println(c);

        c.add("孙悟空");

        c.forEach(o -> System.out.println(o));

        Iterator it = c.iterator();
        it.forEachRemaining(o -> System.out.println(o));

        it = c.iterator();
        while (it.hasNext()){
            Object ele = it.next();
            System.out.println(ele);
            if (ele.equals("JavaScript")){
                it.remove();
            }
        }
        System.out.println(c.size());
        System.out.println(c);
    }
}
