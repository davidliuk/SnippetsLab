// lc141
// 类似求中点的写法，推荐这种写法，模板统一
boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    // 快指针走到末尾时停止
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        // 快慢指针相遇，说明含有环
        if (slow == fast) {
            return true;
        }
    }
    
    return false;
}

// 如下为九章的方法及优化
boolean detectCycle(ListNode head) {
    // 没有元素或仅有一个元素时，不能成环（其实.next那个条件可以去掉，后面可以涵盖）
    if (head == null || head.next == null) {
        return null;
    }
    
    ListNode fast, slow;
    fast = head.next;
    slow = head;
    while (fast != slow) {
        if (fast == null || fast.next == null) {
            return false;
        }
        fast = fast.next.next;
        slow = slow.next;
    }
    
    return true;
}