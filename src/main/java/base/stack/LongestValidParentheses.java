package base.stack;

import base.string.LongestDuplicateSubstring;

import java.util.Stack;

/**
 * @Author: Jeremy
 * @Date: 2020/1/8 19:51
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);

        int result = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char ch = chars[i];
            System.out.println(stack.peek());
            if(ch == ')' && stack.peek() != -1 && chars[stack.peek()] == '(' && stack.size() > 1){
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.add(i);
            }
        }
        return result;
    }

    public int longestValidParentheses3(String s){
        int left = 0;
        int right = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars){
            if (ch == '('){
                left++;
            } else {
                right++;
            }
            if (left == right){
                result = Math.max(result, right * 2);
            } else if (left <= right){
                left = right = 0;
            }
        }

        left = right = 0;
        for (int i = chars.length - 1; i >= 0; i--){
            char ch = chars[i];
            if (ch == '('){
                left++;
            } else {
                right++;
            }
            if (left == right){
                result = Math.max(result, left * 2);
            } else if (left >= right){
                left = right = 0;
            }
        }
        return result;
    }

    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        char[] chars = s.toCharArray();
        int i = 1;
        while(i < chars.length){
            char ch = chars[i];
            if (stack.isEmpty()){
                stack.push(ch);
                i++;
                continue;
            }
            char top = stack.peek();
            if((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')){
                stack.pop();
            } else {
                stack.push(ch);
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int res = longestValidParentheses.longestValidParentheses3(")(()");
        System.out.println(res);
        System.out.println(longestValidParentheses.isValid("[]{}()"));

    }
}
