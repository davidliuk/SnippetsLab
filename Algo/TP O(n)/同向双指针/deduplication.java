// lc83
// 出现重复的元素全部保留一个
ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode slow = head, fast = head;
    while (fast != null) {
        if (fast.val != slow.val) {
            // nums[slow] = nums[fast];
            slow.next = fast;
            // slow++;
            slow = slow.next;
        }
        // fast++
        fast = fast.next;
    }
    // 断开与后面重复元素的连接
    slow.next = null;
    return head;
}

public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode curr = head;
    while (curr.next != null) {
        if (curr.val == curr.next.val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }
    }

    return head;
}

public ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
        return head;
    }
    
    ListNode dummy = new ListNode(-1, head);
    ListNode curr = dummy;
    while (curr.next != null && curr.next.next != null) {
        // 下两个元素不重复，则说明下一个元素是唯一的
        if (curr.next.val != curr.next.next.val) {
            curr = curr.next;
            continue;
        }
        // 保留一个
        curr = curr.next;
        // 删掉剩下的
        int val = curr.next.val;
        while (curr.next != null && curr.next.val == val) {
            curr.next = curr.next.next;
        }
    }

    return dummy.next;
}
