package base.linkList;

/**
 * 有一个单链表，请设计一个算法，使得每K个节点之间逆序，如果最后不够K个节点一组，则不调整最后几个节点。
 * 例如链表1->2->3->4->5->6->7->8->null，K=3这个例子。
 * 调整后为，3->2->1->6->5->4->7->8->null。
 * 因为K==3，所以每三个节点之间逆序，但其中的7，8不调整，因为只有两个节点不够一组。
 * <p>
 * 给定一个单链表的头指针head,同时给定K值，返回逆序后的链表的头指针。
 * <p>
 * 方法一：借助栈
 * 方法二：原链反转
 *
 * @Author: Jeremy
 * @Date: 2018/10/26 19:01
 */

import java.util.*;

public class KInverse {
    public ListNode inverse(ListNode head, int k) {
        // write code here
        return reverseKGroup(head, k);
    }

    // 借助栈的实现
    public static ListNode inverseByStack(ListNode head, int k) {
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        int count = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            if (++count % k == 0) {
                if (count == k) {  // 第一次反转的弹出的节点便是整个链表的头节点
                    head = cur;
                }
                if (tail != null) {
                    tail.next = cur;
                }

                ListNode last = null;
                last = cur;
                cur = cur.next;

                // 弹出前k-1个值，进行反转连接
                while (!stack.isEmpty()) {
                    tail = stack.pop();
                    tail.next = null;
                    last.next = tail;
                    last = tail;
                }
            } else {
                stack.push(cur);  // 入栈
                cur = cur.next;
            }
        }

        // 此时栈不为空，代表最后的元素不足k个
        ListNode next = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (next == null) {
                next = node;
            } else {
                node.next = next;
                next = node;
            }
        }

        tail.next = next;
        return head;
    }

    // 在原链表上直接反转
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // last记录的是上一翻转记录的最后一个节点
        ListNode last = null;
        // cur记录当前节点
        ListNode cur = head;
        // start记录需要翻转的起始节点
        ListNode start = head;

        int count = 0;
        while (cur != null) {
            // 遍历个数达到k的整数倍，代表需要翻转
            // 需要翻转的链表起始点start，到cur节点的下一节点
            if (++count % k == 0){
                ListNode tail = cur.next;
                ListNode n = reverse(start, tail);
                // 第一个翻转的记录，返回的节点即为新链表的头节点
                if (count == k){
                    head = n;
                } else { // 否则，需要将上一翻转链表的最后一个节点指向当前翻转记录的头节点
                    if (last != null) last.next = n;
                }
                // 更新last节点
                last = start;
                // 更新下一个需要翻转记录的起始节点
                start = tail;
                cur = start;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    /**
     * 反转链表某一段
     *
     * @param head
     * @param tail
     * @return
     */
    public static ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return head;
        }
        ListNode last = tail;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != tail && next != null) {
            cur.next = last;
            last = cur;
            cur = next;
            next = next.next;
        }

        cur.next = last;
        return cur;
    }

    public static void main(String args[]) {
        int[] A = {1, 2, 3, 4, 5};
        int k = 2;
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        ListNode res = new KInverse().inverse(head, k);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
