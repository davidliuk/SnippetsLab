// lc206
// 头插法
public ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    ListNode curr = prev.next;
    // 其实这里的null是终止条件
    // 完全可以改成某一个节点，这样就在这个节点前面停下来
    while (curr.next != null) {
        // 将curr的下一个节点挪到dummy的next
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return dummy.next;
}
