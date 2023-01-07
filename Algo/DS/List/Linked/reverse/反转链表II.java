// lc292
// 头插法
public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    for (int i = 0; i < left - 1; i++) {
        prev = prev.next;
    }
    ListNode curr = prev.next;
    // 其实这里的null是终止条件
    // 完全可以改成某一个节点，这样就在这个节点前面停下来
    for (int i = left; i < right; i++) {
        // 将curr的下一个节点挪到dummy的next
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return dummy.next;
}
