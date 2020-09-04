package base.bit;

import java.util.Arrays;

/**
 * 请编写一个算法，不用任何额外变量交换两个整数的值。
 *
 * 给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
 *
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 13:11
 */

public class Swap {
    public int[] getSwap(int[] num) {
        // write code here
        num[0] = num[0] ^ num[1];
        num[1] = num[0] ^ num[1];
        num[0] = num[0] ^ num[1];
        return num;
    }

    public static void main(String[]args){
        Swap swap = new Swap();
        int[] num = new int[]{1,2};
        System.out.println(Arrays.toString(swap.getSwap(num)));
    }
}