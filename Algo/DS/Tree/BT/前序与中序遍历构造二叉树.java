// 缺点：树中不能有重复元素
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        int n = preorder.length;
        return traversal(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode traversal(int[] preorder, int[] inorder, int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd) {
        if (preOrderStart > preOrderEnd) {
            return null;
        }

        int preOrderRoot = preOrderStart;
        int inOrderRoot = indexMap.get(preorder[preOrderRoot]);
        int leftSize = inOrderRoot - inOrderStart;
        int rightSize = inOrderEnd - inOrderRoot;
        TreeNode root = new TreeNode(preorder[preOrderRoot]);

        root.left = traversal(preorder, inorder, preOrderStart + 1, preOrderStart + leftSize, inOrderStart, inOrderRoot - 1);
        root.right = traversal(preorder, inorder, preOrderStart + leftSize + 1, preOrderEnd, inOrderRoot + 1, inOrderEnd);

        return root;
    }
}

class Solution {
    private Map<Integer, Integer> indexMap;

    // 左闭右闭区间
    public TreeNode myBuildTree(int[] preOrder, int[] inOrder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        // 递归终点
        if (preOrderLeft > preOrderRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        int preOrderRoot = preOrderLeft;
        // 在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preOrder[preOrderRoot]);
        
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preOrder[preOrderRoot]);
        // 得到左子树中的节点数目
        int leftSize = inOrderRoot - inOrderLeft;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 leftSize」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preOrder, inOrder, preOrderLeft + 1, preOrderLeft + leftSize, inOrderLeft, inOrderRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preOrder, inOrder, preOrderLeft + leftSize + 1, preOrderRight, inOrderRoot + 1, inOrderRight);
        return root;
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inOrder[i], i);
        }
        
        return myBuildTree(preOrder, inOrder, 0, n - 1, 0, n - 1);
    }
}
