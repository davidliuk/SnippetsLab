// jz18
public ListNode deleteNode(ListNode head, int val) {
    // 这个判断可以去掉，因为其实在下面的循环入口条件覆盖啦
    if (head == null) {
        return null;
    }
    ListNode dummy = new ListNode(-1, head);
    ListNode slow = dummy, fast = head;
    while (fast != null) {
        if (fast.val != val) {
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
    return dummy.next;
}

public ListNode deleteNode(ListNode head, int val) {
    ListNode dummy = new ListNode(-1, head);
    ListNode prev = dummy;
    while (prev != null && prev.next != null) {
        if (prev.next.val == val) {
            prev.next = prev.next.next;
        }
        prev = prev.next;
    }

    return dummy.next;
}
