package base.stack;

/**
 * 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。
 *
 * 测试样例：
 * [4,3,2,1],4
 * 返回：[1,2,3,4]
 *
 * @Author: Jeremy
 * @Date: 2018/10/22 19:08
 */

public class StackReverse {
    public int[] reverseStack(int[] A, int n) {
        // write code here
        if(n==0){
            return null;
        }else{
            int temp = A[n-1];  // 得到栈底元素
            reverseStack(A,n-1);
            A[A.length-n] =  temp;  // 交换至栈底
            return A;
        }
    }
}
