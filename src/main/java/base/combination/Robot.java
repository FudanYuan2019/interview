package base.combination;

/**
 * 在XxY的方格中，以左上角格子为起点，右下角格子为终点，
 * 每次只能向下走或者向右走，请问一共有多少种不同的走法
 * <p>
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 * <p>
 * 测试样例：
 * 2,2
 * 返回：2
 *
 * @Author: Jeremy
 * @Date: 2019/6/3 16:16
 */
public class Robot {
    public int countWays(int x, int y) {
        if (x == 1 || y == 1) {
            return 1;
        }
        int a = x + y - 2;
        int b = x - 1;
        return (int) Combination.getCAB(a, b);
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.countWays(1, 11));
    }
}
