package base.linkList;

/**
 * 有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。
 * 给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。
 * <p>
 * 测试样例：
 * [1,3,4,5,7],[1,2,3,4,0],2
 * 返回：{1,2,3,4,5,7}
 *
 * @Author: Jeremy
 * @Date: 2018/10/25 15:03
 */

public class InsertValue {
    public ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        int len = A.length;
        if (A.length == 0) {
            ListNode curNode = new ListNode(val);
            curNode.next = curNode;
            return curNode;
        }
        ListNode head = new ListNode(A[0]);
        ListNode last = head;
        for (int i = 0; i < len - 1; i++) {
            ListNode node = new ListNode(A[nxt[i]]);
            last.next = node;
            last = node;
        }
        //last.next = head;
        if (val <= head.val) {
            ListNode node = new ListNode(val);
            node.next = head;
            return node;
        }

        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null && val > next.val) {
            cur = next;
            next = next.next;
        }
        ListNode node = new ListNode(val);
        node.next = next;
        cur.next = node;
        return head;
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 设置哨兵
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode cur = head.next;
        ListNode last = head;

        while (cur != null) {
            // 需要插入
            if (cur.val < last.val) {
                ListNode next = cur.next;
                ListNode newLast = dummyHead;
                ListNode node = dummyHead.next; // 需要注意，这里不能是head！！！！
                // 寻找合适位置
                while (cur.val > node.val) {
                    newLast = node;
                    node = node.next;
                }

                // 插入
                last.next = next;
                newLast.next = cur;
                cur.next = node;

                // 更新当前节点为下一节点
                cur = next;

            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String args[]) {
        InsertValue insertValue = new InsertValue();
        int[] A = new int[]{4, 2, 1, 3};
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }
//        ListNode head = insertValue.insert(A, new int[]{1, 2, 3, 4, 0}, 2);
//        ListNode cur = head;
//        for (int i = 0; i < A.length + 1; i++) {
//            System.out.print(cur.val + " ");
//            cur = cur.next;
//        }

        ListNode p = insertionSortList(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

    }
}