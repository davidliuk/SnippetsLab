// lc236, mid
TreeNode lca;

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    lca = root;
    traverse(root, p, q);
    return lca;
}

boolean traverse(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
        return false;
    }

    boolean left = traverse(root.left, p, q);
    boolean right = traverse(root.right, p, q);
    if ((left && right) || ((left || right) && (root == p || root == q))) {
        lca = root;
    }

    return left || right || (root == p || root == q);
}
