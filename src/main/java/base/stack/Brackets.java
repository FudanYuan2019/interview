package base.stack;

import java.util.LinkedList;

/**
 * @Author: Jeremy
 * @Date: 2019/11/8 19:54
 */
public class Brackets {
    public boolean isValid(String s) {
        if (s.length() == 0 ) return true;

        LinkedList<Character> stack = new LinkedList<>();
        for (Character character : s.toCharArray()){
            if (character == '(' || character == '[' || character == '{'){
                stack.push(character);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                boolean a = character == ')' && top != '(';
                boolean b = character == ']' && top != '[';
                boolean c = character == '}' && top != '{';
                if (a || b || c){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean method1(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(s.charAt(0));
        int i = 0;
        while (++i < s.length()) {
            // 如果栈为空，但字符串还没有遍历完，直接入栈
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char top = stack.peek();
            char next = s.charAt(i);
            if (top == '(' && next == ')' ||
                    top == '[' && next == ']' ||
                    top == '{' && next == '}') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        System.out.println(brackets.isValid("([]"));
    }
}
