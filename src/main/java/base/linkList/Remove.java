package base.linkList;

/**
 * @Author: Jeremy
 * @Date: 2018/10/25 15:54
 */
public class Remove {
    public static ListNode removeNode(ListNode head, int delVal) {
        // 如果链表为空，直接返回
        if (head == null) {
            return null;
        }
        // 如果是要删除的正好是头节点，则直接返回下一节点
        if (head.val == delVal) {
            return head.next;
        }

        ListNode last = null;
        ListNode current = head;
        // 遍历节点，寻找要删除的节点，如果删除节点存在，则记录需要删除节点的上一节点
        while (current != null) {
            if (current.val == delVal) {
                break;
            }
            last = current;
            current = current.next;
        }

        // 直接修改待删除节点的上一节点的next指针，指向待删除节点的下一节点即可。
        if (last != null && current != null) {
            last.next = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }

        ListNode p = removeNode(head, 3);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }
}
