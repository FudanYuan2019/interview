package base.linkList;

/**
 * 现在有一个单链表。链表中每个节点保存一个整数，再给定一个值val，把所有等于val的节点删掉。
 * 给定一个单链表的头结点head，同时给定一个值val，请返回清除后的链表的头结点，
 * 保证链表中有不等于该值的其它值。请保证其他元素的相对顺序。
 *
 * 测试样例：
 * {1,2,3,4,3,2,1},2
 * {1,3,4,3,1}
 *
 * @Author: Jeremy
 * @Date: 2018/10/26 21:06
 */
public class ClearValue {
    public ListNode clear(ListNode head, int val) {
        // write code here
        if (head == null){
            return null;
        }

        while (head.val == val){
           head = head.next;
        }

        ListNode cur = head;
        ListNode pre = cur;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
                cur.next = null;
                cur = pre;
            }
            pre = cur;
            cur = cur.next;
        }

        return head;
    }
}
