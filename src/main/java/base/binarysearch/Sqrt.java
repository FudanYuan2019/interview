package base.binarysearch;

/**
 * @Author: Jeremy
 * @Date: 2019/11/17 10:32
 */
public class Sqrt {
    public static int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int min = 0;
        int max = x;
        while (max - min > 1){
            int mid = min + ((max - min) >> 1);
            if (x / mid < mid){
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
