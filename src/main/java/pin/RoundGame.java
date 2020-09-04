package pin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Jeremy
 * @Date: 2020/9/1 16:54
 */
public class RoundGame {
    private static Map<String, Integer> map = new HashMap<>();
    private static Integer normalAttack;
    private static Integer buffedAttack;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hp = scanner.nextInt();
        normalAttack = scanner.nextInt();
        buffedAttack = scanner.nextInt();
        play(hp);
        System.out.println(Math.min(play(hp, 1, true), play(hp - normalAttack, 1, false)));
    }

    public static int play(int restHP, int round, boolean isBuffed) {
        String key = String.format("%d_%s", restHP, isBuffed);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (restHP <= 0) {
            map.put(key, round);
            return round;
        }

        int res;
        if (isBuffed) {
            res = play(restHP - buffedAttack, round + 1, false);
        } else {
            res = Math.min(play(restHP - normalAttack, round + 1, false),
                    play(restHP, round + 1, true));
        }

        map.put(key, res);
        return res;
    }

    public static void play(int hp) {
        if (normalAttack * 2 > buffedAttack) {
            int n = hp / normalAttack;
            int restHP = hp % normalAttack;
            if (restHP > 0) {
                System.out.println(n + 1);
            } else {
                System.out.println(n);
            }
        } else {
            int n = hp / buffedAttack;
            int restHP = hp - buffedAttack * n;
            if (restHP == 0){
                System.out.println(n * 2);
            } else if (restHP <= normalAttack) {
                System.out.println(n * 2 + 1);
            } else {
                System.out.println(n * 2 + 2);
            }
        }
    }
}
