package base.linkList;

/**
 * @Author: Jeremy
 * @Date: 2019/11/5 19:25
 */
public class DeleteDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = null;
        ListNode cur = head;

        while (cur != null) {
            if (last != null && last.val == cur.val) {
                last.next = cur.next;
            } else {
                last = cur;
            }
            cur = cur.next;
        }

        return head;
    }

    /**
     * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
     * 示例 1:
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * <p>
     * 示例 2:
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode last = dummyHead;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && val == cur.val){  // 删除所有重复节点，仅保留只出现一次的节点。
                    cur = cur.next;
                    last.next = cur;
                }
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 去重
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode last = dummyHead;
        ListNode cur = head;
        while(cur.next != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                while(cur.next != null && val == cur.val){  // 去重
                    cur = cur.next;
                    last.next = cur;
                }
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 2, 4};
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        ListNode p = deleteDuplicates2(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();

        p = deleteDuplicates3(head);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
