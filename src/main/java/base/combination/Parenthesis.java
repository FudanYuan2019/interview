package base.combination;

/**
 * 假设有n对左右括号，请求出合法的排列有多少个？
 * 合法是指每一个括号都可以找到与之配对的括号，比如n=1时，()是合法的，但是)(为不合法。
 * <p>
 * 给定一个整数n，请返回所求的合法排列数。保证结果在int范围内。
 * <p>
 * 测试样例：
 * 1
 * 返回：1
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 16:58
 */
public class Parenthesis {
    public int countLegalWays(int n) {
        // write code here
        return (int)Combination.getCAB(2 * n, n) / (n + 1);
    }
    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.countLegalWays(7));
    }
}
