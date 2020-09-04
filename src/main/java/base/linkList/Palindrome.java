package base.linkList;

/**
 * 请编写一个函数，检查链表是否为回文。
 * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
 * <p>
 * 测试样例：
 * {1,2,3,2,1}
 * 返回：true
 * {1,2,3,2,3}
 * 返回：false
 * <p>
 * 方法一：利用栈：时间复杂度：O(n)，空间复杂度：O(n) 或 O(n/2)
 * 方法二：在原链上进行比较
 *
 * @Author: Jeremy
 * @Date: 2018/10/26 21:19
 */

import java.util.*;

public class Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        return judgeInLink(pHead);
    }

    public static boolean judgeByStack(ListNode pHead) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = pHead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = pHead;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            if (cur.val != top.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static boolean judgeByStackHalf(ListNode pHead) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (slow != null && fast != null) {
            stack.push(slow);
            if (fast.next == null) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur;
        cur = slow;
        while (!stack.isEmpty()) {
            ListNode top = stack.pop();
            System.out.println(cur.val + " " + top.val);
            if (cur.val != top.val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static boolean judgeInLink(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        ListNode tail = pHead;
        while (slow != null && fast != null && fast.next == null) {
            tail = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(tail.val + " " + slow.val + " ");
        ListNode pre = null;
        ListNode cur = slow;
        ListNode next = cur.next;
        while (next != null) {
            ListNode next2 = next.next;
            cur.next = pre;
            next.next = cur;
            pre = cur;
            cur = next;
            next = next2;
        }
        ListNode node1 = cur;
        ListNode node2 = pHead;
        while (node1 != null && node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }

        // 调整回去
        pre = null;
        next = cur.next;
        while (next != null) {
            ListNode next2 = next.next;
            cur.next = pre;
            next.next = cur;
            pre = cur;
            cur = next;
            next = next2;
        }

        tail.next = slow;
        return true;
    }

    public static boolean judgeByLink(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode node = reverse(slow);

        while (node != null && head != null) {
            if (node.val != head.val) {
                return false;
            }
            node = node.next;
            head = head.next;
        }

        return true;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = null;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            cur.next = last;
            last = cur;
            cur = next;
            next = next.next;
        }

        cur.next = last;
        return cur;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3, 2, 1};
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        boolean res = judgeByLink(head);
        System.out.println(res);
    }
}
