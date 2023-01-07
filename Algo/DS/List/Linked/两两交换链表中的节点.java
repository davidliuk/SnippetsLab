// lc24
public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode curr = dummy;
    while (curr.next != null && curr.next.next != null) {
        ListNode node1 = curr.next;
        ListNode node2 = curr.next.next;
        curr.next = node2;
        // node1插入到node2后面
        node1.next = node2.next;
        node2.next = node1;
        // 即curr往后走两步
        curr = node1;
    }

    return dummy.next;
}