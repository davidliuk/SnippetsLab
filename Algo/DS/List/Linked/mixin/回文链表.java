// lc
// jz027
public boolean isPalindrome(ListNode head) {
    if (head == null) {
        return true;
    }

    ListNode mid = findMiddle(head);
    ListNode l1 = head;
    ListNode l2 = mid.next;
    mid.next = null;
    l2 = reverse(l2);
    boolean result = isEqual(l1, l2);
    l2 = reverse(l2);
    mid.next = l2;

    return result;
}

public boolean isEqual(ListNode l1, ListNode l2) {
    while (l1 != null && l2 != null) {
        if (l1.val != l2.val) {
            return false;
        }
        l1 = l1.next;
        l2 = l2.next;
    }

    return true;
}

public ListNode reverse(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy, curr = head;
    while (curr.next != null) {
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return dummy.next;
}

public ListNode findMiddle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}
