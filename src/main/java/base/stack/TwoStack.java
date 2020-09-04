package base.stack;

/**
 * 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 * 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 * 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 *
 * 测试样例：
 * [1,2,3,0,4,0],6
 * 返回：[1,2]
 *
 * @Author: Jeremy
 * @Date: 2018/10/8 21:33
 */
import java.util.*;

public class TwoStack {
    public static Stack<Integer> pushStack = new Stack<Integer>();
    public static Stack<Integer> popStack = new Stack<Integer>();
    public int[] twoStack(int[] ope, int n) {
        // write code here
        int num = 0;
        for (int i=0; i<n; i++){
            if (ope[i] == 0){
                num++;
            } else{
                pushStack.push(ope[i]);
            }
        }
        System.out.println(pushStack.toString());
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        int[] array = new int[num];
        for(int i=0; i<num; i++){
            array[i] = popStack.pop();
        }
        return array;
    }

    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < numbers.length; i++){
            if (!stack1.isEmpty() && numbers[i] < stack1.peek()){
                while (!stack1.isEmpty() && numbers[i] < stack1.peek()){
                    stack2.push(stack1.pop());
                }
                stack1.push(numbers[i]);
                while (!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }
            } else{
                stack1.push(numbers[i]);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++){
            ret.add(stack1.pop());
        }
        return ret;
    }

    public static void main(String[] args){
        int[] res = new TwoStack().twoStack(new int[]{1,2,0,4,5, 0}, 6);
        for (int i : res){
            System.out.print(i + " ");
        }
        System.out.println();

        ArrayList<Integer> res2 = new TwoStack().twoStacksSort(new int[]{13,3,34,5,6});
        for (int i : res2){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
