package huawei;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/9/2 19:01
 */
public class Question1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map1 = new TreeMap<>();
        Map<Integer, Integer> map2 = new TreeMap<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int color = scanner.nextInt();
            if (color == 1) {
                map1.put(-num, i + 1);
            } else if (color == 2) {
                map2.put(-num, i + 1);
            }
        }

        int sum1 = 0;
        int sum2 = 0;
        List<Integer> index1 = new ArrayList<>();
        List<Integer> index2 = new ArrayList<>();

        int count1 = 0;
        for (Integer key : map1.keySet()) {
            if (count1 == 3) {
                break;
            }
            index1.add(map1.get(key));
            sum1 += key;
            count1++;
        }

        int count2 = 0;
        for (Integer key : map2.keySet()) {
            if (count2 == 3) {
                break;
            }
            index2.add(map2.get(key));
            sum2 += key;
            count2++;
        }

        sum1 *= -1;
        sum2 *= -1;
        if (sum1 > sum2) {
            if (count1 < 3) {
                System.out.println("null");
                return;
            }
            Collections.sort(index1);
            for (Integer index : index1) {
                System.out.print(index + " ");
            }
            System.out.println();
            System.out.println("1");
            System.out.println(sum1);
        } else if (sum1 < sum2) {
            if (count2 < 3) {
                System.out.println("null");
                return;
            }
            Collections.sort(index2);
            for (Integer index : index2) {
                System.out.print(index + " ");
            }
            System.out.println();
            System.out.println("2");
            System.out.println(sum2);
        } else {
            Collections.sort(index1);
            Collections.sort(index2);
            if (index1.get(0) < index2.get(0)) {
                if (count1 < 3) {
                    System.out.println("null");
                    return;
                }
                for (Integer index : index1) {
                    System.out.print(index + " ");
                }
                System.out.println();
                System.out.println("1");
                System.out.println(sum1);
            } else if (index1.get(0) > index2.get(0)) {
                if (count2 < 3) {
                    System.out.println("null");
                    return;
                }
                Collections.sort(index2);
                for (Integer index : index2) {
                    System.out.print(index + " ");
                }
                System.out.println();
                System.out.println("2");
                System.out.println(sum2);
            } else {
                System.out.println("null");
            }
        }
    }
}

//6
//2 2
//2 1
//3 2
//5 2
//3 1
//7 2