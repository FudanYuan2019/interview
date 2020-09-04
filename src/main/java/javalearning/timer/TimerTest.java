package javalearning.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 *
 * @Author: Jeremy
 * @Date: 2019/10/14 09:30
 */
public class TimerTest {
    public static void main(String[] arg) {
        System.out.println("start");
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("test 5s");
            }
        }, 5000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("test 3s");
            }
        }, 3000);
    }
}
