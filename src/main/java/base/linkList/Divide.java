package base.linkList;

/**
 * 对于一个链表，我们需要用一个特定阈值完成对它的分化，使得小于等于这个值的结点移到前面，
 * 大于该值的结点在后面，同时保证两类结点内部的位置关系不变。
 * 给定一个链表的头结点head，同时给定阈值val，请返回一个链表，
 * 使小于等于它的结点在前，大于等于它的在后，保证结点值不重复。
 * <p>
 * 测试样例：
 * {1,4,2,5},3
 * {1,2,4,5}
 * <p>
 * 方法1：使用额外空间进行快排划分
 * <p>
 * 方法2：类似于荷兰国旗问题的解决，
 * 将整个链表拆分为3个链表（小于给定值的部分，等于，大于）然后进行合并
 *
 * @Author: Jeremy
 * @Date: 2018/10/26 16:39
 */
public class Divide {
    public ListNode listDivide(ListNode head, int val) {
        // write code here
        ListNode cur = head;
        ListNode node1, node2; // 记录最新的尾结点
        node1 = node2 = null;
        ListNode head1, head2; // 记录分开之后的头节点
        head1 = head2 = null;
        while (cur != null) {
            int curVal = cur.val;
            if (curVal <= val) {
                if (node1 != null) {
                    node1.next = cur;
                } else {
                    head1 = cur;
                }
                node1 = cur;
            } else {
                if (node2 != null) {
                    node2.next = cur;
                } else {
                    head2 = cur;
                }
                node2 = cur;
            }
            ListNode copy = cur;  // 每遍历完一个就将该节点分离链表
            cur = cur.next;
            copy.next = null;
        }

//        ListNode node = head1;
//        while (node != null){
//            System.out.print(node.val+ " ");
//            node = node.next;
//        }
//        System.out.println();
//
//        node = head2;
//        while (node != null){
//            System.out.print(node.val+ " ");
//            node = node.next;
//        }
//        System.out.println();

        if (head1 == null) {
            return head2;
        }
        node1.next = head2;
        return head1;
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyHead1 = new ListNode(0);
        ListNode dummyHead2 = new ListNode(0);

        ListNode node1 = dummyHead1;
        ListNode node2 = dummyHead2;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                node1.next = cur;
                cur = cur.next;
                node1 = node1.next;
                node1.next = null;
            } else {
                node2.next = cur;
                cur = cur.next;
                node2 = node2.next;
                node2.next = null;
            }
        }

        node1.next = dummyHead2.next;
        return dummyHead1.next;
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] nodes = new ListNode[k];
        if (root == null) {
            return nodes;
        }

        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int[] countList = new int[k];
        int N = len / k;
        int M = len % k;
        for (int i = 0; i < M; i++) {
            countList[i] = N + 1;
        }
        for (int i = M; i < k; i++) {
            countList[i] = N;
        }

        cur = root;
        ListNode last = null;
        for (int i = 0; i < k; i++) {
            int count = countList[i];
            ListNode dummy = new ListNode(0);
            dummy.next = cur;
            for (int j = 0; j < count; j++) {
                last = cur;
                cur = cur == null ? null : cur.next;
            }
            if (last != null) last.next = null;
            nodes[i] = dummy.next;
        }

        return nodes;
    }

    public static void main(String[] args) {
        Divide divide = new Divide();
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int a = 3;
        ListNode head = new ListNode(A[0]);
        ListNode cur = head;
        for (int i = 1; i < A.length; i++) {
            ListNode node = new ListNode(A[i]);
            cur.next = node;
            cur = node;
        }
//        ListNode node = head;
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
//        System.out.println();
//        ListNode res = partition(head, a);
//        while (res != null) {
//            System.out.print(res.val + " ");
//            res = res.next;
//        }
//        System.out.println();
        ListNode[] nodes = splitListToParts(head, 3);
    }
}
