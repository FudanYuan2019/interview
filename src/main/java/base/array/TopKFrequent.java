package base.array;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/11/14 21:47
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // 使用hashmap记录每个数字出现的频率
        Map<Integer, Integer> map = new HashMap<>();
        int freq = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > freq) {
                freq = map.get(num);
            }
        }

        // 将出现相同频次的数据放入同一桶中
        ArrayList[] bucket = new ArrayList[freq + 1];
        map.forEach((num, count) -> {
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<Integer>();
            }
            bucket[count].add(num);
        });
        List<Integer> res = new ArrayList<>();
        int n = 0;
        for (int i = freq; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for(int j = 0; j < bucket[i].size(); j++){
                if (n++ >= k) break;
                res.add((Integer)bucket[i].get(j));
            }
        }

        return res;
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int freq = 0;
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if(map.get(s.charAt(i)) > freq){
                freq = map.get(s.charAt(i));
            }
        }

        ArrayList[] list = new ArrayList[freq + 1];
        map.forEach((ch, count)->{
            if(list[count] == null){
                list[count] = new ArrayList<Character>();
            }
            list[count].add(ch);
        });

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = freq; i > 0; i--){
            if (list[i] == null) continue;
            for (int j = 0; j < list[i].size(); j++){
                int counter = map.get(list[i].get(j));
                while(counter-- > 0){
                    stringBuffer.append(list[i].get(j));
                }
            }

        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        int[] array = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        List<Integer> res = new TopKFrequent().topKFrequent(array, k);
        System.out.println(res.toString());

        System.out.println(new TopKFrequent().frequencySort("tree"));
    }
}
