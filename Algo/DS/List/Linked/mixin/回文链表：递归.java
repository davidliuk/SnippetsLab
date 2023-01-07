// On, On
// 左侧指针
ListNode left;

boolean isPalindrome(ListNode head) {
    left = head;
    return traverse(head);
}

boolean traverse(ListNode right) {
    if (right == null) {
        return true;
    }
    boolean result = traverse(right.next);
    // 后序遍历代码
    result = result && (right.val == left.val);
    left = left.next;
    return result;
}
