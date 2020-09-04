package javalearning.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Jeremy
 * @Date: 2020/2/13 17:26
 */
public class ConcurrentAdd {
    private ReentrantLock lock = new ReentrantLock();
    private int cn = 0;
    private int cn1 = 0;
    private volatile int cn2 = 0;
    public void add(){
        lock.lock();
        cn++;
        lock.unlock();
    }

    public synchronized void add1(){
        cn1++;
    }

    public void add2(){
        cn2++;
    }

    public int getCn(){
        return this.cn;
    }

    public int getCn1(){
        return this.cn1;
    }

    public int getCn2(){
        return this.cn2;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ConcurrentAdd concurrentAdd = new ConcurrentAdd();
        for (int i = 0; i < 100; i++){
            executorService.execute(() -> concurrentAdd.add());
            executorService.execute(() -> concurrentAdd.add1());
            executorService.execute(() -> concurrentAdd.add2());
        }
        executorService.shutdown();
        System.out.println(concurrentAdd.getCn());
        System.out.println(concurrentAdd.getCn1());
        System.out.println(concurrentAdd.getCn2());
    }
}
