// lc2487
public ListNode removeNodes(ListNode head) {
    head = reverse(head);
    ListNode curr = head;
    
    while (curr.next != null) {
        if (curr.next.val < curr.val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }
    
    return reverse(head);
}

ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    ListNode curr = prev.next;
    while (curr.next != null) {
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }
    
    return dummy.next;
}l