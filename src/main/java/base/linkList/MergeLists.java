package base.linkList;

/**
 * @Author: Jeremy
 * @Date: 2019/11/5 17:12
 */
public class MergeLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode p = l1;
        ListNode q = l2;
        ListNode head = null;
        if (p.val <= q.val){
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        ListNode cur = head;
        while(p != null && q != null){
            if (p.val <= q.val) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }

        if(p != null){
            cur.next = p;
        }
        if (q != null){
            cur.next = q;
        }
        return head;
    }

    public static void main(String[] args){
        int[] A = {1, 3, 4, 6, 7};
        ListNode l1 = new ListNode(A[0]);
        ListNode cur = l1;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        int[] B = {1, 2, 3, 5, 7};
        ListNode l2 = new ListNode(B[0]);
        cur = l2;
        for (int i = 1; i < B.length; i++) {
            ListNode node = new ListNode(B[i]);
            cur.next = node;
            cur = node;
        }

        ListNode p = mergeTwoLists(l1, l2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
