package javalearning.thread;

/**
 * @Author: Jeremy
 * @Date: 2020/2/12 19:05
 */
public class JoinExample {
    private static class A extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("A");
        }
    }

    private static class B extends Thread{
        private A a;
        public B(A a){
            this.a = a;
        }

        @Override
        public void run(){
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void test(){
        A a = new A();
        B b = new B(a);
        b.start();
        a.start();
    }

    public static void main(String[] args) {
        JoinExample joinExample = new JoinExample();
        joinExample.test();
    }
}
