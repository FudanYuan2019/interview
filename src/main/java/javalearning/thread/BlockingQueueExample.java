package javalearning.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Jeremy
 * @Date: 2020/2/17 18:06
 */
class BlockQueueWithCondition {
    private final Queue<String> queue = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public String get() {
        lock.lock();
        try {
            while (queue.peek() == null) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(queue.peek());
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }

    public void put(String request) {
        lock.lock();
        try {
            queue.offer(request);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BlockQueueWithCondition blockingQueueExample = new BlockQueueWithCondition();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            while (true) {
                blockingQueueExample.get();
            }
        });
        executorService.submit(() -> blockingQueueExample.put("A"));
        executorService.submit(() -> blockingQueueExample.put("B"));
        executorService.submit(() -> blockingQueueExample.put("C"));
        executorService.shutdown();
    }
}


class BlockingQueueWithWaitNotify {
    private Queue<String> queue = new LinkedList<>();

    public synchronized String get() {
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(queue.peek());
        return queue.remove();
    }

    public synchronized void put(String element) {
        System.out.println("put: " + element);
        queue.offer(element);
        notifyAll();
    }

    public static void main(String[] args) {
        BlockingQueueWithWaitNotify blockingQueue = new BlockingQueueWithWaitNotify();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> blockingQueue.get());
        executorService.execute(() -> blockingQueue.get());
        executorService.execute(() -> blockingQueue.get());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    blockingQueue.put(String.valueOf(finalI));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }
}

class BlockingQueueExample{
    private Queue<String> queue = new LinkedList<>();
    private int size;
    private int capacity;

    private ReentrantLock lock = new ReentrantLock();
    private Condition unEmpty = lock.newCondition();
    private Condition unFull = lock.newCondition();

    public BlockingQueueExample(int capacity){
        this.capacity = capacity;
        this.size = 0;
    }

    public String get(){
        lock.lock();
        try {
            while (this.size() == 0 || queue.peek() == null){
                try {
                    unEmpty.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            String res = queue.remove();
            this.size--;
            unFull.signalAll();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public void put(String element){
        lock.lock();
        try {
            while (this.size() == capacity){
                try {
                    unFull.await();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            queue.offer(element);
            this.size++;
            unEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}