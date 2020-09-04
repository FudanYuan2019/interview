package base.linkList;

import java.util.ArrayList;

/**
 * @Author: Jeremy
 * @Date: 2018/10/26 18:41
 */
public class Common {
    public int[] findCommonParts(ListNode headA, ListNode headB) {
        // write code here
        ListNode node1, node2;
        node1 = headA;
        node2 = headB;

        ArrayList<Integer> arrayList = new ArrayList<>();
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node1 = node1.next;
            } else if (node1.val > node2.val) {
                node2 = node2.next;
            } else {
                arrayList.add(node1.val);
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 123, 861, 563, 1};
        ListNode headA = new ListNode(A[0]);
        ListNode cur = headA;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        int[] B = {1, 123, 861, 563, 1};
        ListNode headB = new ListNode(B[0]);
        cur = headB;
        for (int i = 1; i < B.length; i++) {
            ListNode node = new ListNode(B[i]);
            cur.next = node;
            cur = node;
        }
        int[] res = new Common().findCommonParts(headA, headB);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
