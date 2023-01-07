// lc2
// 面试题 02.05.
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
        int n1 = 0, n2 = 0;
        if (l1 != null) {
            n1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
        }
        int sum = n1 + n2 + carry;
        carry = sum / 10;
        p.next = new ListNode(sum % 10);
        p = p.next;
    }
    
    return dummy.next;
}

// 类似lc415，字符串相加
// 类似merge的写法
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;
    
    int carry = 0;
    while ((l1 != null && l2 != null) || carry != 0) {
        int n1 = 0, n2 = 0;
        if (l1 != null) {
            n1 = l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            n2 = l2.val;
            l2 = l2.next;
        }
        
        int sum = n1 + n2 + carry;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
    }

    if (l1 != null) {
        curr.next = l1;
    }
    if (l2 != null) {
        curr.next = l2;
    }

    return dummy.next;
}
