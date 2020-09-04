package base.probability;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/30 16:48
 */
public class Random7 {
    private static Random rand = new Random(123456);

    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }

    // 通过rand5实现rand7
    public int randomNumber() {
        while (true) {
            int cur = 5 * (rand5() - 1) + rand5() - 1;
            if (cur < 21) {
                return cur % 7 + 1;
            }
        }
    }

    public static void main(String[] args) {
        Random7 random7 = new Random7();
        int r = random7.randomNumber();
        System.out.println(r);
    }
}
