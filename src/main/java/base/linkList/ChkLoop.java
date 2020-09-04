package base.linkList;

/**
 * 如何判断一个单链表是否有环？有环的话返回进入环的第一个节点的值，无环的话返回-1。
 * 如果链表的长度为N，请做到时间复杂度O(N)，额外空间复杂度O(1)。
 *
 * 给定一个单链表的头结点head（注意另一个参数adjust为加密后的数据调整参数，方便数据设置，与本题求解无关)，
 * 请返回所求值。
 * @Author: Jeremy
 * @Date: 2019/5/19 10:38
 */
public class ChkLoop {
    public int chkLoop(ListNode head, int adjust) {
        if (head == null){
            return -1;
        }

        // 定义一块一慢两指针，快指针一次走两步；慢指针一次走一步；
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowNext, fastNext;
        while (fast != null && slow != null){
            slowNext = slow.next;
            fastNext = fast.next == null ? null : fast.next.next;

            slow = slowNext;
            fast = fastNext;

            if (fast == slow){
                break;
            }
        }

        // 如果链表为无环单链表，则快指针会首先走到null，此时返回-1
        if (fast == null){
            return -1;
        }

        // 如果链表为有环单链表，则快指针与慢指针肯定会在某一节点相遇；
        // 此时慢指针从表头重新进行遍历（步长为1），快指针从上一位置继续遍历（步长也为1），
        // 那么两指针必会在入环节点相遇
        slow = head;
        while (true){
            if (fast == slow){
                break;
            }
            slowNext = slow.next;
            fastNext = fast.next;

            slow = slowNext;
            fast = fastNext;
        }

        return fast.val;
    }

    public static void main(String[] args){

    }
}
