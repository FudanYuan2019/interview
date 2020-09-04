package base.combination;

/**
 * 求n个无差别的节点构成的二叉树有多少种不同的结构？
 * <p>
 * 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
 * <p>
 * 测试样例：
 * 1
 * 返回：1
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 17:18
 */
public class TreeCount {
    public int countWays(int n) {
        // write code here
        return core(n, n);
    }

    public static int core(int i, int n) {
        if (i <= 2) {
            return i;
        }
        if (i == 3) {
            return 5;
        }

        return core(i, n) + core(n - i, n);
    }

    public static void main(String[] args){
        TreeCount treeCount = new TreeCount();
        int res = treeCount.countWays(3);
        System.out.println(res);
    }
}
