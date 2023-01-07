public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    int deep = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        deep++;
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return deep;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    return deep;
}