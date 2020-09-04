package base.array;

/**
 * @Author: Jeremy
 * @Date: 2018/10/5 14:42
 */

import java.util.Arrays;

public class ReverseArray {
    public static void main(String args[]) {
        Integer[] iArray = new Integer[]{101, 102, 103, 104, 105, 106};
        String[] sArray = new String[]{"one", "two", "three", "four", "five"};

        // reverse int array using Apache commons ArrayUtils.reverse() method
        System.out.println("Original int array : " + Arrays.toString(iArray));
        reverse(iArray);
        System.out.println("reversed int array : " + Arrays.toString(iArray));

        // reverse String array using ArrayUtils class
        System.out.println("Original String array : " + Arrays.toString(sArray));
        reverse(sArray);
        System.out.println("reversed String array in Java : " + Arrays.toString(sArray));
    }

    public static void reverse(Object[] array){
        if (array != null){
            int i = 0;
            for(int j = array.length - 1; j > i; i++){
                Object temp = array[j];
                array[j] = array[i];
                array[i] = temp;
                j--;
            }
        }
    }
}
