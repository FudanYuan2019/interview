package acm;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BirthdayParty{
    private static int n;
    private static int m;
    private static class Info{
        public String name;
        public String birthday;
    }
    public static List<Info> infoList = new Vector<Info>();

    private static class Query{
        public int kth;
        public String date;
    }
    public static List<Query> queryList = new Vector<Query>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int line = 0;  // 记录行数
        while(str!=null){
            if(line != 0 && line == 1 + m + n){
                break;
            }
            int col = 0;  // 记录列数
            String[] arr = str.trim().split(" ");
            for(String s : arr){
                //System.out.println(line + " " + s);
                if(line == 0 && col == 0){
                    n = Integer.parseInt(s);
                }

                if(line == 0 && col == 1){
                    m = Integer.parseInt(s);
                }

                if(line != 0 && line <= n && col == 0){
                    Info info = new Info();
                    info.name = s;
                    infoList.add(info);
                }

                if(line != 0 && line <= n && col == 1){
                    infoList.get(line-1).birthday = s;
                }

                if(line > n && col == 0){
                    Query query = new Query();
                    query.kth = Integer.parseInt(s);
                    queryList.add(query);
                }

                if(line > n && col == 1){
                    queryList.get(line-1-n).date = s;
                }
                col++;
            }
            str = br.readLine();
            line++;
        }

        HashMap<String, Map<Integer, String>> map = new HashMap<String, Map<Integer, String>>();

        for (Query query : queryList){
            for (Info info : infoList){
                String birthday1 = info.birthday;
                String name = info.name;
                String day1 = birthday1.substring(4, 8);

                String day2 = query.date;

                if(day1.equals(day2)){
                    //System.out.println(day2);
                    String year = birthday1.substring(0, 4);
                    int age = 2018 - Integer.parseInt(year);

                    if (!map.containsKey(day2)){
                        map.put(day2, new TreeMap<Integer, String>());
                    }
                    map.get(day2).put(-age, name);
                }
            }
        }

        for (Query query : queryList){

            String date = query.date;

            Set<Integer> keySet = map.get(date).keySet();
            Iterator<Integer> iter = keySet.iterator();
            int kth = 0;
            while (iter.hasNext()) {
                Integer key = iter.next();
                if (kth == query.kth-1){
                    System.out.println(map.get(date).get(key));
                }
                kth++;
            }
        }
    }
}