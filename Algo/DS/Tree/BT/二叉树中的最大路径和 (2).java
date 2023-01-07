// 类似二叉树的直接
// 困难
int answer = 0;

public int maxPathSum(TreeNode root) {
    answer = root.val;
    treeHeight(root);
    return answer;
}

int treeHeight(TreeNode root) {
    if (root == null) {
        return 0 ;
    }

    int left = Math.max(treeHeight(root.left), 0);
    int right = Math.max(treeHeight(root.right), 0);
    answer = Math.max(
        answer, 
        left + right + root.val
    );

    return Math.max(left, right) + root.val;
}