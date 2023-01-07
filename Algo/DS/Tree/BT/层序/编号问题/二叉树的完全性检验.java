class Node {
    TreeNode node;
    int index;
    Node(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

public boolean isCompleteTree(TreeNode root) {
    if (root == null) {
        return true;
    }

    Deque<Node> queue = new ArrayDeque();
    queue.offer(new Node(root, 1));
    int counter = 1;
    int lastIndex = 1;

    while (!queue.isEmpty()) {
        TreeNode node = queue.peek().node;
        int index = queue.poll().index;
        if (node.left != null) {
            lastIndex = index * 2;
            queue.offer(new Node(node.left, lastIndex));
            counter++;
        }
        if (node.right != null) {
            lastIndex = index * 2 + 1;
            queue.offer(new Node(node.right, lastIndex));
            counter++;
        }
    }

    return lastIndex == counter;
}
