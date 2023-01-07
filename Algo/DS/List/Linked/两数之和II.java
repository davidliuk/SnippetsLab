// lc445
// 正序的数字相加
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Deque<Integer> stack1 = new ArrayDeque<Integer>();
    Deque<Integer> stack2 = new ArrayDeque<Integer>();
    while (l1 != null) {
        stack1.push(l1.val);
        l1 = l1.next;
    }
    while (l2 != null) {
        stack2.push(l2.val);
        l2 = l2.next;
    }
    
    ListNode dummy = new ListNode(-1);
    int carry = 0;
    while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
        int n1 = stack1.isEmpty() ? 0 : stack1.pop();
        int n2 = stack2.isEmpty() ? 0 : stack2.pop();
        int sum = n1 + n2 + carry;
        carry = sum / 10;
        
        ListNode node = new ListNode(sum % 10);
        // 把新的放在头的位置（插入到头）
        node.next = dummy.next;
        dummy.next = node;
    }
    
    return dummy.next;
}
