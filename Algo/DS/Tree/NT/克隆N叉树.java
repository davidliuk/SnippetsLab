// lc1490
// dfs based
public Node cloneNTree(TreeNode root) {
    if (root == null) {
        return root;
    }

    // 克隆节点
    TreeNode cloneRoot = new TreeNode(root.val);

    // 遍历该节点的儿子并更新克隆节点的儿子列表
    for (TreeNode child: node.children) {
        cloneNode.children.add(cloneGraph(child));
    }
    
    return cloneNode;
}
