package base.probability;

import java.util.*;

/**
 * 有一个机器按自然数序列的方式吐出球，1号球，2号球，3号球等等。
 * 你有一个袋子，袋子里最多只能装下K个球，并且除袋子以外，
 * 你没有更多的空间，一个球一旦扔掉，就再也不可拿回。
 * 设计一种选择方式，使得当机器吐出第N号球的时候，你袋子中的球数是K个，
 * 同时可以保证从1号球到N号球中的每一个，被选进袋子的概率都是K/N。
 * <p>
 * 举一个更具体的例子，有一个只能装下10个球的袋子，当吐出100个球时，袋子里有10 球，
 * 并且1~100号中的每一个球被选中的概率都是10/100。
 * 然后继续吐球，当吐出1000个球时，袋子里有 10 个球，
 * 并且1~1000号中的每一个球被选中的概率都是10/1000。
 * 继续吐球，当吐出i个球时，袋子里有10个球，并且1~i号中的每一个球被选中的概率都是10/i。
 * 也就是随着N的变化，1~N号球被选中的概率动态变化成k/N。
 * 请将吐出第N个球时袋子中的球的编号返回。
 *
 * @Author: Jeremy
 * @Date: 2019/5/30 18:22
 * <p>
 * 蓄水池抽样算法
 * <p>
 * 解题思路：
 * （1）处理1~k号球时，直接放入袋子；
 * （2）处理到i号球时，以k/i的概率决定是否将第i号球放入袋子。
 * 如果不放入袋子，直接扔掉i号球；如果放入袋子，就将袋子中的球随机扔掉一个，再放入袋子。
 * （3) 处理i+1号球时，重复（1）（2）两步操作；
 */
public class Bag{
    private int[] selected = null;

    private static Random rand = new Random(12345);

    // 每次拿一个球都会调用这个函数，N表示第i次调用
    public int[] carryBalls(int N, int k) {
        if (selected == null) {
            selected = new int[k];
        }
        if (N <= k) {
            selected[N - 1] = N;
        } else {
            if (rand.nextInt(N) < k) {
                int p = rand.nextInt(k);
                selected[p] = N;
            }
        }
        return selected;
    }

    public static void main(String[] args) {
        Bag bag = new Bag();
        int N = 1000;
        int k = 10;
        for (int i = 1; i <= N; i++) {
            bag.carryBalls(i, k);
        }
        System.out.println(Arrays.toString(bag.selected));

        int i = 5;
        int j = 10;
        System.out.println(i + ~j);

        byte b = (byte)130;
        byte c = (byte)128;
        System.out.println(b);
        System.out.println(c);

        int a = Integer.parseInt("123a");
        System.out.println(a);

        int[] arr = null;
        arr[0] = 1;
        System.out.println(Arrays.toString(arr));
    }
}
