package base.stack;

import java.util.Arrays;

/**
 * 用数组实现一个栈
 *
 * @Author: Jeremy
 * @Date: 2019/11/7 11:55
 */
public class StackWithArray {
    private int top = 0;
    private int capacity;
    private int[] stack;

    public StackWithArray(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
    }

    public void push(int value) {
        // 判满条件
        if (this.top == this.capacity) {
            return;
        }
        this.stack[this.top++] = value;
    }

    public int pop() {
        // 判空条件
        if (this.top == 0) {
            return -1;
        }
        return this.stack[--this.top];
    }

    public boolean isEmpty() {
        return this.top == 0;
    }

    public int size() {
        return this.top;
    }

    public static void main(String[] args) {
        StackWithArray stackWithArray = new StackWithArray(4);
        stackWithArray.push(1);
        stackWithArray.push(2);
        stackWithArray.push(3);
        stackWithArray.push(4);
        System.out.println(stackWithArray.size());
        while (!stackWithArray.isEmpty()){
            System.out.println(stackWithArray.pop());
        }
    }
}
