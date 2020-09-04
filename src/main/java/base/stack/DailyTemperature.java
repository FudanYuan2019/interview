package base.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: Jeremy
 * @Date: 2019/11/8 20:44
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indexs.isEmpty() && T[i] > T[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = i - preIndex;
            }
            indexs.add(i);
        }
        return dist;
    }

    public int[] method1(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = i + 1; j < T.length; j++) {
                count++;
                if (T[j] > T[i]) {
                    flag = true;
                    break;
                }
            }
            res[i] = flag ? count : 0;
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            int value = nums[i % len];
            while (!stack.isEmpty() && value > nums[stack.peek()]){
                int topIndex = stack.pop();
                res[topIndex] = value;
            }
            if(i < len) stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 6};
        int[] res = new DailyTemperature().nextGreaterElements(A);
        System.out.println(Arrays.toString(res));
    }
}
