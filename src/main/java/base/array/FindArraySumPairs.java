package base.array;

/**
 * 找出数组中和为S的一对组合，找出一组就行
 *
 * @Author: Jeremy
 * @Date: 2018/10/5 14:15
 */

import java.util.*;

public class FindArraySumPairs {
    public static void main(String args[]) {
//        prettyPrint(getRandomArray(9), 11);
//        prettyPrint(getRandomArray(10), 12);

        prettyPrint(new int[]{0,-1,-3,5,-5}, 1);
    }

    /**
     * Given an array of integers finds two elements in the array whose sum is equal to sum.
     *
     * @param numbers
     * @param sum
     */
    public static int[] pairsUsingSet(int[] numbers, int sum) {
        if (numbers.length < 2) {
            return null;
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            int value = numbers[i];
            int target = sum - value;
            // if target number is not in set then add
            if (map.containsKey(target)) {
                res[1] = map.get(target);
                res[0] = i;
                return res;
            } else {
                map.put(value, i);
            }
        }
        return res;
    }

    /**
     * Given an array of integers finds two elements in the array whose sum is equal to sum.
     *
     * @param numbers
     * @param sum
     */
    public static void printPairsUsingBinary(int[] numbers, int sum) {
        if (numbers.length < 2) {
            return;
        }

        Arrays.sort(numbers);

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int k = numbers[left] + numbers[right];
            if (k == sum) {
                System.out.printf("(%d, %d) %sum", numbers[left], numbers[right]);
                left += 1;
                right -= 1;
            } else if (k > sum) {
                right -= 1;
            } else {
                left += 1;
            }
        }
    }

    /**
     * Given an array of integers finds two elements in the array whose sum is equal to sum.
     *
     * @param numbers
     * @param sum
     */
    public static List<List<Integer>> find3Pairs(int[] numbers, int sum) {
        if (numbers.length < 3) {
            return Arrays.asList();
        }

        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i == 0 || (i > 0 && numbers[i] != numbers[i - 1])) {
                int left = i + 1;
                int right = numbers.length - 1;
                int subSum = sum - numbers[i];
                while (left < right) {
                    if (subSum == numbers[left] + numbers[right]) {
                        result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                        while (left < right && numbers[left] == numbers[left + 1]) left++;
                        while (left < right && numbers[right] == numbers[right - 1]) right--;
                        left++;
                        right--;
                    } else if (subSum > numbers[left] + numbers[right]) {
                        while (left < right && numbers[left] == numbers[left + 1]) left++;
                        left++;
                    } else if (subSum < numbers[left] + numbers[right]) {
                        while (left < right && numbers[right] == numbers[right - 1]) right--;
                        right--;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Given an array of integers finds two elements in the array whose sum is equal to sum.
     *
     * @param numbers
     * @param sum
     */
    public static List<List<Integer>> find4Pairs(int[] numbers, int sum) {
        if (numbers.length < 4) {
            return null;
        }
        if (numbers.length == 4 && numbers[0] + numbers[1] + numbers[2] + numbers[3] == sum){
            return Arrays.asList(Arrays.asList(numbers[0], numbers[1], numbers[2], numbers[3]));
        }
        Arrays.sort(numbers);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numbers.length - 3; i++) {

            if (i == 0 || (i > 0 && numbers[i] != numbers[i - 1])) {
                int[] subNumbers = new int[numbers.length - i - 1];
                for (int j = 0; j < subNumbers.length; j++) {
                    subNumbers[j] = numbers[j + i + 1];
                }
                List<List<Integer>> temp = find3Pairs(subNumbers, sum - numbers[i]);
                if (temp.size() != 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    for (int j = 0; j < temp.size(); j++) {
                        list.addAll(temp.get(j));
                        result.add(list);

                        list = new ArrayList<>();
                        list.add(numbers[i]);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Utility method to find two elements in an array that sum to k.
     */
    public static void prettyPrint(int[] random, int k) {
        System.out.println("Random7 Integer array : " + Arrays.toString(random));
        System.out.println("Sum : " + k);
        System.out.println("pair of numbers from an array whose sum equals " + k);
        int[] res1 = pairsUsingSet(random, k);
        System.out.println(Arrays.toString(res1));
        List<List<Integer>> res = find4Pairs(random, k);
        for (List<Integer> list : res) {
            System.out.println("list: " + list.toString());
        }
    }

    /**
     * Utility method to return random array of Integers in a range of 0 to 15
     */
    public static int[] getRandomArray(int length) {
        int[] randoms = new int[length];
        for (int i = 0; i < length; i++) {
            randoms[i] = (int) (Math.random() * 15);
        }
        return randoms;
    }


}
