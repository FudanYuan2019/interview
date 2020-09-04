package javalearning.thread;

/**
 * @Author: Jeremy
 * @Date: 2020/3/29 09:15
 */
public class DeadLockExample extends Thread {
    private String first;
    private String second;

    public DeadLockExample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000L);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                // Do nothing
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockExample t1 = new DeadLockExample("Thread1", lockA, lockB);
        DeadLockExample t2 = new DeadLockExample("Thread2", lockB, lockA);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("test end");
    }
}