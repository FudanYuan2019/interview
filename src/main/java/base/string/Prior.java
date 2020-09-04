package base.string;

/**
 * @Author: Jeremy
 * @Date: 2018/10/19 17:32
 */
import java.util.*;
public class Prior {
    public String findSmallest(String[] strs, int n) {
        if(strs == null || strs.length <= 0){
            return null;
        }

        Arrays.sort(strs,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String a = s1+s2;
                String b = s2+s1;
                return a.compareTo(b);
            }

        });
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            sb.append(strs[i]);
        }
        return sb.toString();

    }
}

