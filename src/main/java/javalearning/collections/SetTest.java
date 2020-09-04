package javalearning.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Jeremy
 * @Date: 2019/5/27 15:14
 */
public class SetTest {

    public static void main(String[] args){
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(3);
        set.add(1);
        System.out.println(set.size());
        System.out.println(Arrays.toString(set.toArray()));
    }
}
