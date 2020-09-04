package javalearning.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: Jeremy
 * @Date: 2020/2/13 17:12
 */
public class ProducerConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread{
        @Override
        public void run() {
            try {
                queue.put("producer");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consumer extends Thread{
        @Override
        public void run() {
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){
            Producer producer = new Producer();
            producer.start();
        }

        for (int i = 0; i < 5; i++){
            Consumer consumer = new Consumer();
            consumer.start();
        }

        for (int i = 0; i < 3; i ++){
            Producer producer = new Producer();
            producer.start();
        }
    }
}
