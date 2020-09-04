package base.classic;

/**
 * 汉诺塔：汉诺塔（又称河内塔）问题是源于印度一个古老传说的益智玩具。
 * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照
 * 大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小
 * 顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在
 * 三根柱子之间一次只能移动一个圆盘。
 *
 * @Author: Jeremy
 * @Date: 2018/11/1 13:07
 */
public class Hanoi {
    public void hanoi(int n, char start, char by, char end){
        if (n == 1){
            System.out.println(n + " " + start + " by " + by + " to " + end);
        } else {
            hanoi(n-1, start, end, by);
            System.out.println(n + " " + start + " by " + by + " to " + end);
            hanoi(n-1, by, start, end);
        }
    }

    public static void main(String args[]){
        Hanoi hanoi = new Hanoi();
        hanoi.hanoi(1, 'A', 'B', 'C');
    }
}
