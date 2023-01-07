
public Node copyList(Node head) {
    if (head == null) {
        return null;
    }
    Node headNew = new Node(head.val);
    // 本质上是后序遍历
    headNew.next = copyList(head.next);
    return headNew;
}

// 复制二叉树
public TreeNode copyTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode cloneRoot = new TreeNode(root.val);
    // 本质上是后序遍历，需要用到子树的结果
    cloneRoot.left = copyTree(root.left);
    cloneRoot.right = copyTree(root.right);
    return cloneRoot;
}
