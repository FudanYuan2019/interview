package base.linkList;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）。
 *
 * @Author: Jeremy
 * @Date: 2019/5/18 19:47
 */
public class CopyLinkList {
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        RandomListNode cur = pHead;
        RandomListNode next;
        // 复制节点
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = next;
        }

        // 确定radom节点
        cur = pHead;
        while (cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        // 分开两链表，保证原始链表的正确性
        RandomListNode newHead = pHead.next;
        cur = pHead;
        RandomListNode copy = cur.next;
        while (cur != null) {
            next = cur.next.next;
            cur.next = copy.next;
            copy.next = next == null ? null : next.next;
            copy = copy.next;
            cur = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);

        RandomListNode b = new RandomListNode(2);

        RandomListNode c = new RandomListNode(3);

        RandomListNode d = new RandomListNode(4);

        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a.random = c;
        b.random = e;
        c.random = null;
        d.random = b;
        e.random = null;

        RandomListNode haed = new CopyLinkList().Clone(a);
        RandomListNode p = haed;
        while (p != null) {
            System.out.print(p.label + " ");
            p = p.next;
        }

        p = haed;
        while (p != null) {
            System.out.print((p.random != null ? p.random.label : "#") + " ");
            p = p.next;
        }
        System.out.println();
        p = a;
        while (p != null) {
            System.out.print(p.label + " ");
            p = p.next;
        }

        p = haed;
        while (p != null) {
            System.out.print((p.random != null ? p.random.label : "#") + " ");
            p = p.next;
        }

    }
}

