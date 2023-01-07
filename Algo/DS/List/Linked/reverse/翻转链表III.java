// 这种可以给前后节点，然后翻转中间，会保留原来的结构
// 不包括tail，返回子链新的头尾
public ListNode[] reverseList(ListNode prev, ListNode tail) {
    ListNode head = prev.next;
    ListNode curr = prev.next;
    while (curr.next != tail) {
        // 将curr的下一个节点挪到dummy的next
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return new ListNode[]{prev.next, head};
}
