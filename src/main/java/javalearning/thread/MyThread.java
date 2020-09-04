package javalearning.thread;

/**
 * @Author: Jeremy
 * @Date: 2020/2/10 18:15
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            if (i == 4){
                Thread.yield();
            }
        }
//        System.out.println();
//        try {
//            Thread.sleep(3000);
//            System.out.println("thread run");
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
//        MyThread myThread3 = new MyThread();
//        myThread3.start();
//        myThread3.interrupt();
//        System.out.println("main run");
    }
}


class MyThread1 extends Thread{
    @Override
    public void run(){
        while(!interrupted()){
            System.out.println("running");
        }
        System.out.println("thread stop");
    }

    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
    }
}