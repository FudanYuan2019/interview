package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Jeremy
 * @Date: 2020/2/11 16:07
 */
public class SynchronizedExample {
    public void func1(){
        synchronized (this){
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void func2(){
        synchronized (SynchronizedExample.class){
            for (int i = 0; i < 10; i++){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> synchronizedExample.func1());
        executorService.execute(() -> synchronizedExample.func1());
        executorService.shutdown();

        SynchronizedExample synchronizedExample1 = new SynchronizedExample();
        SynchronizedExample synchronizedExample2 = new SynchronizedExample();
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        executorService1.execute(() -> synchronizedExample1.func1());
        executorService1.execute(() -> synchronizedExample2.func1());
        executorService1.shutdown();

        SynchronizedExample synchronizedExample3 = new SynchronizedExample();
        SynchronizedExample synchronizedExample4 = new SynchronizedExample();
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        executorService2.execute(() -> synchronizedExample3.func2());
        executorService2.execute(() -> synchronizedExample4.func2());
        executorService2.shutdown();
    }
}
