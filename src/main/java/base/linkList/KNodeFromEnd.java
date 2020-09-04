package base.linkList;

/**
 * 获取链表的倒数第K个节点
 * 思路：使用两个指针，第一个指针先走k步，然后第二个指针（从头节点开始）与第一个指针（第k个节点）同时遍历，
 * 当第2个指针遍历至链表结尾时，第一个指针指向的节点便是倒数第k个节点。
 *
 * @Author: Jeremy
 * @Date: 2019/11/5 12:45
 */
public class KNodeFromEnd {
    public static ListNode kNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode first = head;
        while (k-- > 0) {
            first = first.next;
        }

        ListNode second = head;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    public static ListNode delKNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        // 先走K步
        int n = 0;
        ListNode first = head;
        while (first != null) {
            if (n == k) {
                break;
            }
            first = first.next;
            n++;
        }

        // 当第一个指针走到链表尾部时，第二个指针正好走到倒数第K个节点
        ListNode second = head;
        ListNode last = null;
        while (first != null && second != null) {
            first = first.next;
            last = second;
            second = second.next;
        }

        // 为防止k大于链表长度，因此需要判断last是否为空
        if (last != null && second != null) {
            last.next = second.next;
        }

        // 如果要删除的是头节点，则返回头节点的下一节点即可
        if (second == head) {
            return head.next;
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

        ListNode p = kNodeFromEnd(head, 6);
        if (p != null) {
            System.out.print(p.val + " ");
        }
        System.out.println();

        ListNode newHead = delKNodeFromEnd(head, 3);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
        System.out.println();
    }
}
