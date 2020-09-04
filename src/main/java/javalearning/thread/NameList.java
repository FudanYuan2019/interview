package javalearning.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2019/5/26 10:30
 */
public class NameList {
    private List names = new ArrayList();
    public synchronized void add(String name)
    {
        names.add(name);
    }
    public synchronized void printAll()     {
        for (int i = 0; i < names.size(); i++)
        {
            System.out.print(names.get(i) + "");
        }
    }

    public static void main(String[]args) throws Exception
    {
//        final NameList sl = new NameList();
//        for (int i = 0; i < 2; i++)
//        {
//            new Thread()
//            {
//                @Override
//                public void run()
//                {
//                    sl.add("A");
//                    sl.add("B");
//                    sl.add("C");
//                    sl.printAll();
//                }
//            }.start();
//        }

        final Object obj = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                    System.out.println("Thread 1 wake up.");
                } catch (InterruptedException e) {
                }
            }
        });
        t1.start();
        Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                obj.notifyAll();
                System.out.println("Thread 2 sent notify.");
            }
        });
        t2.start();
    }
}
