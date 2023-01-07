// 单链表：线性（可迭代可递归）
// 迭代
void traverse(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        // 迭代访问 arr[i]
    }
}

// 递归
void traverse(ListNode head) {
    // 递归访问 head.val
    traverse(head.next);
}

// 多叉链表：非线性（主要递归）
// 所有递归问题，都是多叉树遍历（如图或全排序等）

// 二叉树：递归
void traverse(TreeNode head) {
    // 前序递归访问 head.val
    traverse(head.left);
    // 中序递归访问 head.val
    traverse(head.right);
    // 后序递归访问 head.val
}

// N叉树：递归
void traverse(TreeNode head) {
    for (TreeNode child: root.children) {
        // 递归访问 head.val
        traverse(child);
    }
}