package base.probability;

import java.util.*;

/**
 * @Author: Jeremy
 * @Date: 2019/5/30 17:56
 */
public class Random01 {
    private static double p = new Random().nextFloat();

    // 随机概率p
    public static int f() {
        return new Random().nextFloat() < p ? 0 : 1;
    }

    public int random01() {
        // 通过f函数实现01等概率返回
        while (true) {
            int a = f();
            int b = f();
            if (a == 0 && b == 1) {
                return 0;
            }
            if (a == 1 && b == 0) {
                return 1;
            }
        }
    }
}
