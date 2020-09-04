package jd;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2020/8/26 20:14
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int n = in.nextInt();
//            int s = in.nextInt();
//            Map<String, Map<Integer, Integer>> map = new HashMap<>();
//            map.put("S", new TreeMap<>(Comparator.reverseOrder()));
//            map.put("B", new TreeMap<>(Comparator.reverseOrder()));
//            in.nextLine();
//            for (int i = 0; i < n; i++) {
//                String string = in.nextLine();
//                String[] s1 = string.split(" ");
//                map.get(s1[0]).put(Integer.valueOf(s1[1]),
//                        Integer.parseInt(s1[2]) + map.get(s1[0]).getOrDefault(Integer.valueOf(s1[1]), 0));
//            }
//
//            for (String key : Arrays.asList("S", "B")) {
//                int tmp1 = 0;
//                for (Integer amount : map.get(key).keySet()) {
//                    if (++tmp1 > s) break;
//                    System.out.println(key + " " + amount + " " + map.get(key).get(amount));
//                }
//            }
//        }
//    }
//6 2
//B 10 3
//S 50 2
//S 40 1
//S 50 6
//B 20 4
//B 25 10
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int count1 = 0;
            int count2 = 0;
            int[][] state = new int[3][3];

            for (int i = 0; i < 3; i++) {
                char[] chars = in.nextLine().toCharArray();
                for (int j = 0; j < 3; j++){
                    if (chars[j] == 'X') {
                        count1++;
                        state[i][j] = 1;
                    }
                    else if (chars[j] == '0') {
                        count2++;
                        state[i][j] = 2;
                    }
                }
            }
            int diff = count1 - count2;

            if (diff != 1 && diff != 0) {
                System.out.println("x");
                continue;
            }

            boolean wonX = isWon(state,1);
            boolean won0 = isWon(state,2);

            if (wonX && won0 || wonX && diff == 0 || won0 && diff == 1) {
                System.out.println("x");
                continue;
            }
            // 判断是否有一方胜出
            if (wonX) {
                System.out.println("1 won");
                continue;
            }

            if (won0) {
                System.out.println("2 won");
                continue;
            }

            if (count1 - count2 == 1) {
                System.out.println("2");
                continue;
            }
            if (count1 == count2) {
                System.out.println("1");
                continue;
            }
            if (count1 + count2 == 9) {
                System.out.println("draw");
            }
        }
    }

    public static boolean isWon(int[][] state, int side) {
        for (int i = 0; i < 3; i++){
            if (side == state[i][0] && side == state[i][1] && side == state[i][2]) {
                return true;
            }
            if (side == state[0][i] && side == state[1][i] && side == state[2][i]) {
                return true;
            }
        }

        if (side == state[0][0] && side == state[1][1] && side == state[2][2]) {
            return true;
        }

        if (side == state[2][0] && side == state[1][1] && side == state[0][2]) {
            return true;
        }

        return false;
    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int m = in.nextInt();
//            int n = in.nextInt();
//            double sum = 0;
//            double tmp = m;
//            for (int i = 0; i < n; i++){
//                sum += tmp;
//                tmp = Math.sqrt(tmp);
//            }
//            System.out.println(String.format("%.2f", sum));
//        }
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int m = in.nextInt();
//            int n = in.nextInt();
//            boolean found = false;
//            for (int i = m; i <= n; i++) {
//                if (isShuiXianHua(i)) {
//                    found = true;
//                    System.out.print(i + " ");
//                }
//            }
//
//            if (!found) {
//                System.out.print("no");
//            }
//            System.out.println();
//        }
//    }
//
//    public static boolean isShuiXianHua(int x) {
//        int sum = 0;
//        int tmp = x;
//        while(tmp > 0) {
//            int m = tmp % 10;
//            sum += m * m * m;
//            tmp /= 10;
//        }
//        return sum == x;
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int m = in.nextInt();
//            int n = in.nextInt();
//
//            List<Integer> list1 = new ArrayList<>(m);
//            List<Integer> list2 = new ArrayList<>(n);
//            for (int i = 0; i < m; i++) {
//                list1.add(in.nextInt());
//            }
//
//            for (int i = 0; i < n; i++) {
//                list2.add(in.nextInt());
//            }
//
//            list1.addAll(list2);
//            Collections.sort(list1);
//
//            Set<Integer> set = new LinkedHashSet<>(list1);
//            for (Integer ele : set) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int m = in.nextInt();
//            int n = in.nextInt();
//
//            List<Integer> list1 = new ArrayList<>(m);
//            for (int i = 0; i < m; i++) {
//                list1.add(in.nextInt());
//            }
//
//            Map<String, Integer> map = new HashMap<>();
//            in.nextLine();
//            for (int i = 0; i < n; i++) {
//                String good = in.nextLine();
//                if (map.containsKey(good)) {
//                    map.put(good, map.get(good) + 1);
//                } else {
//                    map.put(good, 1);
//                }
//            }
//
//            List<Integer> count = new ArrayList<>(map.values());
//            Collections.sort(count);
//
//            int min = 0;
//            int max = 0;
//
//            Collections.sort(list1);
//            for (int i = 0; i < count.size(); i++) {
//                min += list1.get(i) * count.get(count.size() - i - 1);
//                max += list1.get(m - i - 1) * count.get(count.size() - i - 1);
//            }
//            System.out.println(min + " " + max);
//        }
//        System.out.println(func(2015));
//
//    }
//
//    public static int func(int x)
//    {
//        int count = 0;
//        while(x > 0)
//        {
//            count++;
//            x = x & (x-1);
//        }
//        return count;
//    }

}
