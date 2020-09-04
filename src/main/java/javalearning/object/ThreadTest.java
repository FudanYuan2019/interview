package javalearning.object;

/**
 * @Author: Jeremy
 * @Date: 2019/5/24 11:01
 */
public class ThreadTest extends Thread{
    @Override

    public void run() {

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.print("run");

    }

    public static void main(String args[]) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("2");
        });
        t.start();

//        t.join();
        System.out.print("1");

        ThreadTest example = new ThreadTest();

        // main run
        example.start();
        // run main
        //example.run();

        System.out.print("main");

    }

}
