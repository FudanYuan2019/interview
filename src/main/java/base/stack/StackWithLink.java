package base.stack;

import base.linkList.ListNode;

/**
 * @Author: Jeremy
 * @Date: 2019/11/7 12:40
 */
public class StackWithLink {
    private int capacity;
    private int size = 0;
    private ListNode top = new ListNode(0);

    public StackWithLink(int capacity){
        this.capacity = capacity;
        this.size = 0;
    }

    public int push(int value){
        ListNode node = new ListNode(value);
        node.next = this.top.next;
        this.top.next = node;
        this.size++;
        return value;
    }

    public int peek(){
        if (isEmpty()){
            return -1;
        }
        return this.top.next.val;
    }

    public int pop(){
        if (isEmpty()){
            return -1;
        }
        int val = this.top.next.val;
        this.top.next = this.top.next.next;
        return val;
    }

    public boolean isEmpty(){
        return this.top.next == null;
    }

    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        StackWithLink stackWithLink = new StackWithLink(10);
        stackWithLink.push(1);
        stackWithLink.push(2);
        stackWithLink.push(3);
        stackWithLink.push(4);
        System.out.println(stackWithLink.getSize());
        System.out.println(stackWithLink.peek());
        System.out.println(stackWithLink.pop());
        while (!stackWithLink.isEmpty()){
            System.out.println(stackWithLink.pop());
        }

    }
}
