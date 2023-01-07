// lc160
// 面试题 02.07. 
// 简单写法
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) {
        return null;
    }
    
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    
    return pA;
}

// 把一个链表的末尾和另一个的起点连在一起，如果出现环了，则有交集，否则无
ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // 第一个链表没有一个元素时，不可能有共有元素
    if (headA == null) {
        return null;
    }
    
    // 找到A的末尾和B的首部连起来
    ListNode lastA = headA;
    while(lastA.next != null) {
        lastA = lastA.next;
    }
    lastA.next = headB;
    
    // 链表判环
    ListNode fast, slow;
    fast = headA.next;
    slow = headA;
    while (fast != slow) {
        if (fast == null || fast.next == null) {
            lastA.next = null; 
            return null;
        }
        fast = fast.next.next;
        slow = slow.next;
    }
    
    ListNode head = headA;
    while (head != null && head != slow.next) {
        head = head.next;
        slow = slow.next;
    }
    
    // 断开两个链表的连接
    lastA.next = null;
    return head;
}
