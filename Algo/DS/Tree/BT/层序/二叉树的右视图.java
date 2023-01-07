// lc199 mid
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList();
    if (root == null) {
        return result;
    }

    Queue<TreeNode> queue = new ArrayDeque();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        result.add(queue.peek().val);
        for (int i = 0; i < levelSize; i++) {
            TreeNode curr = queue.poll();
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }
    }

    return result;
}