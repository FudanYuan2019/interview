package javalearning.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Jeremy
 * @Date: 2020/2/13 16:36
 */
public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int threadCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadCount; i++){
            executorService.execute(() -> {
                System.out.print("run..  ");
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }
}
