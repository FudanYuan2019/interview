package base.combination;

/**
 * @Author: Jeremy
 * @Date: 2019/6/3 16:24
 */
public class Combination {
    public static long getCAB(int a, int b){
        if (a == b){
            return 1;
        }
        int c = a - b;
        long a1 = a;
        for (int i = a; i > 1; i--) {
            a1 *= i - 1;
        }
        long b1 = b;
        for (int i = b; i > 1; i--) {
            b1 *= i - 1;
        }

        long c1 = c;
        for (int i = c; i > 1; i--) {
            c1 *= i - 1;
        }
        System.out.println(a1 + " " + b1 + " " + c1);
        return a1 / (b1 * c1);
    }

    public static int factorial(int n) {
        int res = 1;
        for (int i = n; i >= 1; i--) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(Combination.getCAB(14, 7));
    }
}
