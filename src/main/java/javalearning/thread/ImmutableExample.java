package javalearning.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Jeremy
 * @Date: 2020/2/14 11:59
 */
public class ImmutableExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        int i = unmodifiableMap.get("a");
        System.out.println(i);

        // throw exception
        // unmodifiableMap.put("b", 2);
    }
}
