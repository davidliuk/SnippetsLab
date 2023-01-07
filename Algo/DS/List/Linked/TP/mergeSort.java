// lc148
// jz077
public ListNode sortList(ListNode head) {
    if (head == null) {
        return null;
    }

    return mergeSort(head, null);
}

public ListNode mergeSort(ListNode head, ListNode tail) {
    // 这种情况下只有一个元素，则先把他断开
    if (head.next == tail) {
        head.next = null;
        return head;
    }
    
    ListNode mid = findMiddle(head, tail);
    ListNode left = mergeSort(head, mid);
    ListNode right = mergeSort(mid, tail);
    
    return merge(left, right);
}

public ListNode findMiddle(ListNode head, ListNode tail) {
    ListNode slow =  head, fast = head;
    while (fast != tail && fast.next != tail) {
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
}

public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    ListNode p1 = l1, p2 = l2;

    while (p1 != null && p2 != null) {
        if (p1.val < p2.val) {
            p.next = p1;
            p1 = p1.next;
        } else {
            p.next = p2;
            p2 = p2.next;
        }
        p = p.next;
    }

    if (p1 != null) {
        p.next = p1;
    }
    if (p2 != null) {
        p.next = p2;
    }

    return dummy.next;
}
