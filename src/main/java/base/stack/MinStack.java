package base.stack;

import base.linkList.ListNode;

import java.util.LinkedList;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 *
 * @Author: Jeremy
 * @Date: 2019/11/8 19:25
 */
public class MinStack {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();
    int min = Integer.MAX_VALUE;
    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (x < min){
            min = x;
        }
        stack1.push(x);
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        min = stack2.isEmpty() ? Integer.MAX_VALUE : stack2.peek(); // 必须更新min的值
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}