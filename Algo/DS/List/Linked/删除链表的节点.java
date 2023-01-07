// jz18
public ListNode deleteNode(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy;
    while (prev != null && prev.next != null) {
        if (prev.next.val == val) {
            prev.next = prev.next.next;
        }
        prev = prev.next;
    }

    return dummy.next;
}