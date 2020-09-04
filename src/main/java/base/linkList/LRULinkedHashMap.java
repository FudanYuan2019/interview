package base.linkList;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Jeremy
 * @Date: 2019/12/27 11:07
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    public int capacity;
    public LRULinkedHashMap(int capacity){
        super(16,0.75f,true);
        this.capacity = capacity;
    }
    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > capacity;
    }

    public static void main(String[] args) {
        LRULinkedHashMap<Integer, Integer> lruLinkedHashMap = new LRULinkedHashMap<>(5);
        lruLinkedHashMap.put(1, 1);
        lruLinkedHashMap.put(2, 2);
        lruLinkedHashMap.put(3, 3);
        lruLinkedHashMap.put(4, 4);
        lruLinkedHashMap.put(5, 5);
        lruLinkedHashMap.get(3);
        lruLinkedHashMap.get(2);
        lruLinkedHashMap.put(6, 6);
        lruLinkedHashMap.forEach((key, value)->{
            System.out.println(key + " " + value);
        });
    }
}