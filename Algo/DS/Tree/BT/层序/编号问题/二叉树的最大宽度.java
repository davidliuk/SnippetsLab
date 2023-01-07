class Node {
    TreeNode node;
    int index;
    Node(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int ans = 0;
    Deque<Node> queue = new ArrayDeque();
    queue.offer(new Node(root, 1));

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        int left = queue.getLast().index;
        int right = queue.getFirst().index;
        ans = Math.max(ans, left - right + 1);
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.peek().node;
            int index = queue.poll().index;
            if (node.left != null) {
                queue.offer(new Node(node.left, index * 2));
            }
            if (node.right != null) {
                queue.offer(new Node(node.right, index * 2 + 1));
            }
        }
    }

    return ans;
}