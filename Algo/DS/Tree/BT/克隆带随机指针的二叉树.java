// lc1485
// 本质上是一张特殊的出度不大于3的图
// 类似复制带随机指针的链表，及本质上是复制图
// On,On
// 本质上就是visited表
Map<TreeNode, TreeNode> visited = new HashMap<>();

public Node copyRandomTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
    if (visited.containsKey(root)) {
        return visited.get(root);
    }
    // 克隆节点
    TreeNode node = new Node(root.val);
    visited.put(root, node);
    
    // 二叉树后序遍历
    node.left = copyRandomList(root.left);
    node.right = copyRandomList(root.right);
    node.random = copyRandomList(root.random);
    
    return node;
}
