package pin;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/9/1 16:38
 */
public class MinDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }
        Collections.sort(list);
        int maxSum = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0, j = N - 1; i < N / 2; i++, j--) {
            maxSum = Math.max(maxSum,  list.get(i) + list.get(j));
            minSum = Math.min(minSum,  list.get(i) + list.get(j));
        }
        System.out.println(maxSum - minSum);
    }
}
