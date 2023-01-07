// lc143
// jz026
public void reorderList(ListNode head) {
    if (head == null) {
        return;
    }

    ListNode mid = findMiddle(head);
    ListNode l1 = head, l2 = mid.next;
    mid.next = null;
    l2 = reverse(l2);
    merge(l1, l2);
}

public ListNode findMiddle(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

public ListNode reverse(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy, curr = head;
    while (curr.next != null) {
        ListNode next = curr.next;
        // 将next移出
        curr.next = next.next;
        // 把next插入到prev后面
        next.next = prev.next;
        prev.next = next;
    }

    return dummy.next;
}

public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    ListNode p1 = l1, p2 = l2;

    while (l1 != null && l2 != null) {
        p.next = l1;
        p1 = p1.next;
        p = p.next;

        p.next = l2;
        p2 = p2.next;
        p = p.next;
    }

    if (p1 != null) {
        p.next = p1;
    }

    return dummy.next;
}
