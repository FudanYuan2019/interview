package base.linkList;

/**
 * @Author: Jeremy
 * @Date: 2019/5/19 10:57
 */
public class CheckIntersect {
    /**
     * 检测链表是否有环
     *
     * @param head
     * @param adjust
     * @return
     */
    public ListNode chkLoop(ListNode head, int adjust) {
        if (head == null) {
            return null;
        }

        // 定义一块一慢两指针，快指针一次走两步；慢指针一次走一步；
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
            if (fast == slow) {
                break;
            }
        }

        // 如果链表为无环单链表，则快指针会首先走到null，此时返回null
        if (fast == null) {
            return null;
        }

        // 如果链表为有环单链表，则快指针与慢指针肯定会在某一节点相遇；
        // 此时慢指针从表头重新进行遍历（步长为1），快指针从上一位置继续遍历（步长也为1），
        // 那么两指针必会在入环节点相遇
        slow = head;
        while (true) {
            if (fast == slow) {
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    /**
     * 现在有两个无环单链表，若两个链表的长度分别为m和n，
     * 请设计一个时间复杂度为O(n + m)，额外空间复杂度为O(1)的算法，
     * 判断这两个链表是否相交。
     *
     * 给定两个链表的头结点headA和headB，请返回一个bool值，代表这两个链表是否相交。
     * 保证两个链表长度小于等于500
     * @param headA
     * @param headB
     * @return
     */
    /**
     * 返回相交的第一个节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public int intersection(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return -1;
        }

        // 先获取两链表长度
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        ListNode nextA, nextB;
        while (curA != null) {
            nextA = curA.next;
            lenA++;
            curA = nextA;
        }
        while (curB != null) {
            nextB = curB.next;
            lenB++;
            curB = nextB;
        }

        curA = headA;
        curB = headB;
        // 如果链表A较长，则A先走delta步
        if (lenA > lenB) {
            int delta = lenA - lenB;
            while (delta >= 0) {
                nextA = curA.next;
                delta--;
                curA = nextA;
            }
        }
        // 如果链表B较长，则B先走delta步
        if (lenA < lenB) {
            int delta = lenB - lenA;
            while (delta >= 0) {
                nextB = curB.next;
                delta--;
                curB = nextB;
            }
        }

        // 遍历剩下的节点，如果相遇则相交
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA.val;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return -1;
    }

    /**
     * 返回相交节点（无环）
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headA : node1.next;
            node2 = node2 == null ? headB : node2.next;
        }
        return node1;
    }

    /**
     * 直接比较最后一个节点是否相等即可
     *
     * @param headA
     * @param headB
     * @return
     */
    public boolean chkIntersect(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return false;
        }

        ListNode curA = headA;
        ListNode curB = headB;
        while (curA.next != null) {
            curA = curA.next;
        }
        while (curB.next != null) {
            curB = curB.next;
        }
        return curA == curB;
    }

    /**
     * 如何判断两个有环单链表是否相交？相交的话返回第一个相交的节点，不相交的话返回空。
     * 如果两个链表长度分别为N和M，请做到时间复杂度O(N+M)，额外空间复杂度O(1)。
     * <p>
     * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
     * 请返回一个bool值代表它们是否相交。
     * @param loopNode1
     * @param loopNode2
     * @param adjust0
     * @param adjust1
     * @return
     */
    public boolean chkLoopInter(ListNode loopNode1, ListNode loopNode2, int adjust0, int adjust1) {
        if (loopNode1 == null || loopNode2 == null) {
            return false;
        }
        // 如果两入环点相同，则代表一定相交
        if (loopNode1 == loopNode2) {
            return true;
        }

        // 遍历环内节点，如果某一个节点相交，则两链表相交
        ListNode cur2 = loopNode2;
        while (cur2.next != loopNode2) {
            if (cur2 == loopNode1) {
                return true;
            }
            cur2 = cur2.next;
        }
        return false;
    }

    /**
     * 给定两个单链表的头节点head1和head2，如何判断两个链表是否相交？
     * 相交的话返回true，不相交的话返回false。
     * <p>
     * 给定两个链表的头结点head1和head2(注意，另外两个参数adjust0和adjust1用于调整数据,与本题求解无关)。
     * 请返回一个bool值代表它们是否相交。
     *
     * @param head1
     * @param head2
     * @param adjust0
     * @param adjust1
     * @return
     */
    public boolean chkIntersect(ListNode head1, ListNode head2, int adjust0, int adjust1) {
        // 首先判断两链表是否有环
        if (head1 == null || head2 == null) {
            return false;
        }
        // 首先找到环的第一个节点
        ListNode loopNode1 = chkLoop(head1, adjust0);
        ListNode loopNode2 = chkLoop(head2, adjust1);

        // 如果两链表都无环
        if (loopNode1 == null && loopNode2 == null) {
            return chkIntersect(head1, head2);
        }

        // 如果两链表都有环
        if (loopNode1 != null && loopNode2 != null) {
            return chkLoopInter(loopNode1, loopNode2, adjust0, adjust1);
        }

        return false;
    }
}
