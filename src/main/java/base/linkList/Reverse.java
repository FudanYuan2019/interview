package base.linkList;

/**
 * @Author: Jeremy
 * @Date: 2019/11/5 12:14
 */
public class Reverse {
    /**
     * 不使用哨兵，直接原地翻转
     *
     * @param head
     * @return
     */
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

    /**
     * 使用哨兵，尾插法
     *
     * @param head
     * @return
     */
    public static ListNode reverseWithDummy(ListNode head) {
        ListNode newHead = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        k = k % len;

        ListNode first = head;
        int count = 0;
        while (first != null) {
            if (count == k) {
                break;
            }
            first = first.next;
            count++;
        }
        // 如果first正好等于头节点，代表不需要任何操作，直接返回head即可
        if (first == head) {
            return head;
        }
        ListNode second = head;
        ListNode firstTail = null;
        ListNode secondTail = null;
        while (first != null && second != null) {
            firstTail = first;
            secondTail = second;
            second = second.next;
            first = first.next;
        }
        if (secondTail != null) secondTail.next = first;
        if (firstTail != null) firstTail.next = head;

        return second;
    }

    public static ListNode rotateRight2(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = 0;
        ListNode last = null;
        ListNode cur = head;
        while (cur != null) {
            len++;
            last = cur;
            cur = cur.next;
        }
        k = len - k % len - 1;
        // 构成一个循环链表
        last.next = head;
        cur = head;
        int count = 0;
        while (cur != null) {
            if (count++ == k) {
                break;
            }
            cur = cur.next;
        }
        if (cur != null) {
            head = cur.next;
            cur.next = null;
        }
        return head;
    }

    /**
     * 翻转m-n节点
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 找到需要翻转节点的上一节点
        ListNode last = dummyHead;
        for (int i = 1; i < m; i++) {
            last = last.next;
        }

        // 依次翻转需要翻转的节点
        ListNode node = last.next;
        for (int i = m; i < n; i++) {
            ListNode next = node.next;
            node.next = next.next;
            next.next = last.next;
            last.next = next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 4, 6, 7};
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        ListNode p;
//        p = reverseWithDummy(head);
//        while (p != null) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
//        System.out.println();

//        p = reverse(head);
//        while (p != null) {
//            System.out.print(p.val + " ");
//            p = p.next;
//        }
//        System.out.println();

        p = reverseBetween(head, 3, 5);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
