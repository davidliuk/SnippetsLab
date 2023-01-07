public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return equals(root.left, root.right);
}

public boolean equals(TreeNode a, TreeNode b) {
    if (a == null || b == null) {
        return a == null && b == null;
    }
    if (a.val != b.val) {
        return false;
    }
    boolean left = equals(a.left, b.right);
    if (left != true) {
        return false;
    }
    boolean right = equals(a.right, b.left);
    
    return right;
}
