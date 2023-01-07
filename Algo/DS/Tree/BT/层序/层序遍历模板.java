public List<List<Integer>> levelOrder(TreeNode root) {
    List result = new ArrayList();
    
    if (root == null) {
        return result;
    }
    
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        ArrayList<Integer> level = new ArrayList<Integer>();
        // 对上一层内容的操作，一定非空
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode head = queue.poll();
            level.add(head.val);
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
        }
        // 对下一层的操作，注意下一层可能会是空
        result.add(level);
    }
    
    return result
}