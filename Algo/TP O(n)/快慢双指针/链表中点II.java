// 偶数：前面一个，奇数：正中间的
// 经常用于需要从中点后断开的情况，如
ListNode middleNode(ListNode head) {
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
