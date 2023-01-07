// lc25
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    while (head != null) {
        ListNode tail = prev;
        // 查看剩余部分长度是否大于等于 k
        for (int i = 0; i < k; i++) {
            tail = tail.next;
            // 已经处理完了
            if (tail == null) {
                return dummy.next;
            }
        }
        ListNode next = tail.next;
        ListNode[] reverse = reverseList(prev, next);
        tail = reverse[1];
        prev = tail;
        head = tail.next;
    }

    return dummy.next;
}

public ListNode[] reverseList(ListNode prev, ListNode end) {
    ListNode head = prev.next;
    ListNode curr = prev.next;
    while (curr.next != end) {
        // 将curr的下一个节点挪到dummy的next
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return new ListNode[]{prev.next, head};
}

// or

// lc25
// 旧版，需要重新连接prev到head
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;

    while (head != null) {
        ListNode tail = prev;
        // 查看剩余部分长度是否大于等于 k
        for (int i = 0; i < k; i++) {
            tail = tail.next;
            // 已经处理完了
            if (tail == null) {
                return dummy.next;
            }
        }
        ListNode next = tail.next;
        ListNode[] reverse = reverseList(head, tail);
        head = reverse[0];
        tail = reverse[1];
        // 把子链表重新接回原链表
        prev.next = head;
        prev = tail;
        head = tail.next;
    }

    return dummy.next;
}

public ListNode[] reverseList(ListNode head, ListNode tail) {
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    ListNode curr = prev.next, end = tail.next;
    while (curr.next != end) {
        // 将curr的下一个节点挪到dummy的next
        ListNode next = curr.next;
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
    }

    return new ListNode[]{tail, head};
}
