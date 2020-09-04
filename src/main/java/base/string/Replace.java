package base.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jeremy
 * @Date: 2019/11/14 19:23
 */
public class Replace {
    public String replaceSpace(StringBuffer str) {
        String string = str.toString();
        return string.replaceAll(" ", "%20");
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : array){
            int value = sum - num;
            if (!set.contains(value)){
                set.add(num);
            } else{
                res.add(value);
                res.add(num);
            }
        }
        return res;
    }
}
