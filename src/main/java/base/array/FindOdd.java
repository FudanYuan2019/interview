package base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个数组，除一个元素外其它都是两两相等，求那个元素?
 *
 * @Author: Jeremy
 * @Date: 2019/11/4 13:45
 */
public class FindOdd {

    /**
     * 对于有且仅有一个数字仅出现奇数次的情况
     * @param array
     * @return
     */
    public static int findOdd1(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        return result;
    }

    /**
     * 对于有且仅有两个数字出现奇数次的情况
     * @param array
     * @return
     */
    public static int[] findOdd2(int[] array) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        int temp = result;

        int flag = 1;
        while (temp != 0){
            if (temp % 2 == 1){
                break;
            }
            flag <<= 1;
            temp /= 2;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int tmp = array[i] & flag;
            if (tmp == 0){
                list1.add(array[i]);
            } else{
                list2.add(array[i]);
            }
        }
        int[] a1 = new int[list1.size()];
        int[] a2 = new int[list2.size()];
        for (int i = 0; i < a1.length; i++){
            a1[i] = list1.get(i);
        }
        for (int i = 0; i < a2.length; i++){
            a2[i] = list2.get(i);
        }
        int[] res = new int[2];
        res[0] = findOdd1(a1);
        res[1] = findOdd1(a2);
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 2, 3, 3};
        System.out.println(Arrays.toString(a));

        int odd = findOdd1(a);
        System.out.println("the only one is " + odd);

        a = new int[]{212, 42, 212, 31, 31, 52};
        System.out.println(Arrays.toString(a));

        int[] odd2 = findOdd2(a);
        System.out.println("the only two is " + Arrays.toString(odd2));
    }
}
