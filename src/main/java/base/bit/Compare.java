package base.bit;

/**
 * @Author: Jeremy
 * @Date: 2019/6/3 14:18
 */
public class Compare {
    public int getMax(int a, int b) {
        int c = a - b;
        // 判断a,b,c的符号——0:负数，1:正数
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        // 判断a，b是否同符号
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);

        // 如果a，b符号相同，则返回sc * a + nsc * b
        // 如果a，b符号不同，则返回sa * a + nsa * b
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public int getMaxBasic(int a, int b) {
        int c = a - b;
        int sc = sign(c);
        int nsc = flip(sc);
        return a * sc + b * nsc;
    }

    /**
     * 取反操作
     * @param n
     * @return
     */
    public int flip(int n) {
        return n ^ 1;
    }

    /**
     * 返回a的首位，0为负数，1为正数
     *
     * @param n
     * @return
     */
    public int sign(int n) {
        return flip(n >> 31 & 1);
    }

    public static void main(String[] args) {
        Compare compare = new Compare();
        System.out.println(compare.sign(-10));
        System.out.println(compare.sign(10));
        System.out.println(compare.flip(-10));
        System.out.println(compare.flip(10));

        System.out.println(compare.getMaxBasic(10, 2));
        System.out.println(compare.getMax(10, -2));
        System.out.println(compare.getMax(-10, 2));
        System.out.println(compare.getMax(-10, -2));
    }
}
