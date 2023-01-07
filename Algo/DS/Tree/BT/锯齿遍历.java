public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result =  new ArrayList<List<Integer>>();
    if (root == null) {
        return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
    queue.offer(root);

    Boolean isReverse = true;

    while (!queue.isEmpty()) {
        Deque<Integer> level = new ArrayDeque<Integer>();
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode curr = queue.poll();
            if (isReverse) {
                level.offerLast(curr.val);
            } else {
                level.offerFirst(curr.val);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        result.add(new ArrayList(level));
        isReverse = !isReverse;
    }

    return result;

}