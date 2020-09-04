package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/5 14:20
 */

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumberInArray {
    public static void main(String args[]){
        int[] a = new int[]{1,2,3,5};
        findOne(a, 5);

        int[] b = new int[]{4,5,7,8,9};
        findOne(b, 6);

        int[] c = new int[]{1,2,3,5,7};
        findAll(c, 7);

        int[] d = new int[]{4,5,7,8,9};
        findAll(d, 9);
    }

    /**
     * if there is only one missing number
     * @param numbers
     * @param n
     */
    public static void findOne(int[] numbers, int n){
        int a1 = numbers[0];
        int expectSum = a1 * n + n * (n - 1) / 2;
        int realSum = 0;
        for (int number : numbers){
            realSum += number;
        }
        int miss = expectSum - realSum;
        System.out.printf("whole array is %s, the missing number is %d %n", Arrays.toString(numbers), miss);
    }

    /**
     * if there are more than 2 missing numbers
     * @param numbers
     * @param n
     */
    public static void findAll(int[] numbers, int n){
        int len = numbers.length;
        BitSet bitSet = new BitSet(n);
        for (int number : numbers){
            bitSet.set(number-1);
        }
        int missNum = n - len;
        int miss = 0;

        System.out.printf("whole array is %s: %n", Arrays.toString(numbers));
        for (int i=0; i<missNum; i++){
            miss = bitSet.nextClearBit(miss);
            System.out.printf("missing number: %d %n", ++miss);
        }
    }
}
