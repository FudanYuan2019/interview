package base.combination;

/**
 * A(A也是他的编号)是一个孤傲的人，在一个n个人(其中编号依次为1到n)的队列中，
 * 他于其中的标号为b和标号c的人都有矛盾，所以他不会和他们站在相邻的位置。
 * 现在问你满足A的要求的对列有多少种？
 * <p>
 * 给定人数n和三个人的标号A,b和c，请返回所求答案，保证人数小于等于11且大于等于3。
 * <p>
 * 测试样例：
 * 6,1,2,3
 * 288
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 16:31
 */
public class LonelyA {
    public int getWays(int n, int A, int b, int c) {
        // write code here
        int total = Combination.factorial(n);
        int com1 = Combination.factorial(n - 2) * (n - 1) * 4;
        int com2 = 2 * (n - 2) * Combination.factorial(n - 3);
        return total - com1 + com2;
    }

    public static void main(String[] args) {
        LonelyA lonelyA = new LonelyA();
        System.out.println(lonelyA.getWays(6, 1, 2, 3));
    }
}
