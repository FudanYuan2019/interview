package base.queue;

/**
 * @Author: Jeremy
 * @Date: 2018/10/8 21:30
 */

import java.util.LinkedList;

public class test {
    public static void main(String args[]){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        Integer top = queue.poll();
        System.out.println(top);

    }
}
