package interview;

import java.util.*;

public class Main {
    private static int[] numsMap = new int[6];
    private static int[] elements = new int[]{2, 3, 5};

    public static void main(String[] args) {
        init();
        method1();
    }

    public static void init() {
        int sum = 0;
        for (int i = 1; i < 7; i++) {
            int tmp = 1;
            for (int j = 0; j < i; j++){
                tmp *= 3;
            }
            sum += tmp;
            numsMap[i - 1] = sum;
            if (sum >= 1000) {
                break;
            }
        }
    }

    public static void method1() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int level;
            for (level = 0; level < numsMap.length; level++) {
                if (n <= numsMap[level]) {
                    break;
                }
            }
            int indexInPos;
            if (level > 0) {
                indexInPos = n - numsMap[level - 1] - 1;
            } else {
                indexInPos = n - 1;
            }

            System.out.println(make(level, indexInPos));
        }
    }

    // level是第几层，index是这一层的第几个节点
    public static int make(int level, int index) {
        int tmp = index;
        Stack<Integer> stack = new Stack<>();
        for (int i = level; i >= 0; i--){
            stack.push(tmp % 3);
            tmp = tmp / 3;
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum *= 10;
            sum += elements[stack.pop()];
        }

        return sum;
    }
}
