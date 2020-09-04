package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/5 14:22
 */

public class MaximumMinimumInArray {
    public static void main(String args[]){
        int[] a = new int[]{1,4,5,6,2,41,0,-1};
        find(a);
    }

    public static void find(int[] numbers){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int number : numbers){
            if (number > max){
                max = number;
            }
            if (number < min) {
                min = number;
            }
        }
        System.out.printf("max: %d, min: %d %n", max, min);
    }
}
