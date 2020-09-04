package thread;

/**
 * @Author: Jeremy
 * @Date: 2019/12/23 15:25
 */
public class Test {
    public static void main(String[] args) {
        Thread t = new Thread(() -> pong());
        t.start();
        System.out.print("ping");
    }
    static void pong() {
        System.out.print("pong");
    }
}

class ThreadNumTest {
    public static void main(String[] args) {
        System.out.println("Hello world");
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        int nowThreads = topGroup.activeCount();
        Thread[] lstThreads = new Thread[nowThreads];
        topGroup.enumerate(lstThreads);
        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number：" + i + " = " + lstThreads[i].getName());
        }
    }
}
