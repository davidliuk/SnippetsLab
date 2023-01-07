// 链表不支持索引交换，故采用merge的逆操作（链表mergeO1空间）
// 时间O(n)
// 框架O(1)，原理：链表指针操作，不需要自己开辟一篇空间
// 链表分解
ListNode partition(ListNode head, int x) {
    // 存放小于 x 的链表的虚拟头结点
    ListNode dummy1 = new ListNode(-1);
    // 存放大于等于 x 的链表的虚拟头结点
    ListNode dummy2 = new ListNode(-1);
    // p1, p2 指针负责生成结果链表
    ListNode p1 = dummy1, p2 = dummy2;
    // p 负责遍历原链表，类似合并两个有序链表的逻辑
    // 这里是将一个链表分解成两个链表
    ListNode p = head;
    while (p != null) {
        if (p.val < x) {
            p1.next = p;
            p1 = p1.next;
        } else {
            p2.next = p;
            p2 = p2.next;
        }
        // 断开原链表中的每个节点的 next 指针（便于使每一步的dummy链跟的都只有自己链的东西（其实可以在下面的方法中优化））
        ListNode temp = p.next;
        p.next = null;
        p = temp;
    }
    // 连接两个链表
    p1.next = dummy2.next;

    return dummy1.next;
}

// 简化断链
public ListNode partition(ListNode head, int x) {
    ListNode dummy1 = new ListNode(-1);
    ListNode dummy2 = new ListNode(-1);

    ListNode p1 = dummy1, p2 = dummy2;
    ListNode p = head;
    while (p != null) {
        if (p.val < x) {
            p1.next = p;
            p1 = p1.next;
        } else {
            p2.next = p;
            p2 = p2.next;
        }
        p = p.next;
    }
    p2.next = null;
    p1.next = dummy2.next;

    return dummy1.next;
}

