// lc82
// 出现重复的元素全部删掉，可能删掉头，所以dummy
ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }
    
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy, curr = prev.next;
    while (curr != null) {
        ListNode next = curr.next;
        while (next != null && curr.val == next.val) {
            next = next.next;
        }
        if (next != curr.next) {
            // next 移动过，则中间存在重复元素
            // 将 prev 的 next 指针指向 next
            // 删除重复元素
            prev.next = next;
        } else {
            // next 没有移动过，prev 向后移动一位
            prev = curr;
        }
        // curr 向后移动一位
        curr = next;
    }
    
    return dummy.next;
}

ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }
    
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    while (prev.next != null && prev.next.next != null) {
        if (prev.next.val != prev.next.next.val) {
            // 无重复，prev 向后移动一位
            prev = prev.next;
            continue;
        }
        int val = prev.next.val;
        while (prev.next != null && prev.next.val == val) {
            prev.next = prev.next.next;
        }
    }
    
    return dummy.next;
}
