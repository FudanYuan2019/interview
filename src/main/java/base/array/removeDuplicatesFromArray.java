package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/5 14:20
 */

import java.util.Arrays;

public class removeDuplicatesFromArray {
    public static void main(String arg[]){
        int[] a = new int[]{1,2,1,1,1,2,3};
        remove(a);
    }

    public static void remove(int[] numbers){
        System.out.println("the origin array is " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        int[] result = new int[numbers.length];
        int previous = numbers[0];
        result[0] = previous;
        for (int i=1; i<numbers.length; i++){
            int num = numbers[i];
            if (num != previous){
                result[i] = num;
            }
            previous = num;
        }

        System.out.println("the current array is " + Arrays.toString(result));
    }
}
