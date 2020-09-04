package base.linkList;

/**
 * 来了一个新的元素，先判断该元素是否已存在链表中，
 * 如果存在，则将旧元素删除，并将该元素插入头节点
 * 如果不存在，则需要判断链表是否已满，
 * 如果链表已满，则删除链表尾，并将元素插入头节点
 * 如果链表未满，则直接将元素插入头节点。
 *
 * @Author: Jeremy
 * @Date: 2019/11/7 12:55
 */
public class LRU {
    private ListNode dummyHead = new ListNode(-1);
    private int cacheSize;
    private int size;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        this.size = 0;
    }

    public void update(int value) {
        ListNode last = dummyHead;
        ListNode cur = dummyHead.next;
        boolean flag = false;
        while (cur != null) {
            if (cur.val == value) {
                flag = true;
                break;
            }
            last = cur;
            cur = cur.next;
        }
        ListNode node = new ListNode(value);
        // 缓存池已满
        if (this.size == this.cacheSize){
            // 不存在该元素，直接删除尾节点
            if (!flag){
                cur = dummyHead.next;
                last = dummyHead;
                while(cur.next != null){
                    last = cur;
                    cur = cur.next;
                }
                last.next = null;
            }
        } else {
            // 如果链表中存在该元素，删除该元素
            if (flag){
                last.next = cur.next == null ? null : cur.next.next;
            } else{
                size++;
            }
        }
        // 将该元素添加至头节点
        node.next = dummyHead.next;
        dummyHead.next = node;
    }

    public void cacheList(){
        ListNode cur = this.dummyHead.next;
        while (cur != null){
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.update(1);
        lru.cacheList();
        lru.update(2);
        lru.cacheList();
        lru.update(1);
        lru.cacheList();
        lru.update(4);
        lru.cacheList();
        lru.update(5);
        lru.cacheList();
    }
}
