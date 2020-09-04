package javalearning.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Jeremy
 * @Date: 2020/2/14 11:45
 */
public class AtomicExample {
    private AtomicInteger cnt = new AtomicInteger();

    public void add(){
        cnt.incrementAndGet();
    }

    public int get(){
        return cnt.get();
    }

    public static void main(String[] args) throws InterruptedException {
        int threadSize = 100;
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        AtomicExample atomicExample = new AtomicExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++){
            executorService.execute(() -> atomicExample.add());
            countDownLatch.countDown();
        }

        countDownLatch.await();
        System.out.println(atomicExample.get());
        executorService.shutdown();
    }
}
