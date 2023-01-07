// lc142
// jz022
// 链表求环入口
// 类似求中点的写法，推荐这种写法，模板统一
ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {
            // 重新指向头结点
            slow = head;
            // 快慢指针同步前进，相交点就是环起点
            while (slow != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
    
    return null;
}

// 如下为九章的方法及优化
ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    
    ListNode fast, slow;
    fast = head.next;
    slow = head;
    while (fast != slow) {
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = fast.next.next;
        slow = slow.next;
    }
    
    while (head != slow.next) {
        head = head.next;
        slow = slow.next;
    }
    
    return head;
}

// 或者，如下就是不弄丢head
ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) {
        return null;
    }
    
    ListNode fast, slow;
    fast = head.next;
    slow = head;
    while (fast != slow) {
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = fast.next.next;
        slow = slow.next;
    }
    
    slow = head;
    while (head != slow.next) {
        fast = fast.next;
        slow = slow.next;
    }
    
    return slow;
}
