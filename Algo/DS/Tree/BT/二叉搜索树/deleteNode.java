class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 找最小的比root大的元素
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            // 将该元素从原位置移除
            root.right = deleteNode(root.right, successor.val);
            // 将该元素替换过去
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 找最大的比root小的元素
            TreeNode successor = root.left;
            while (successor.right != null) {
                successor = successor.right;
            }
            // 将该元素从原位置移除
            root.left = deleteNode(root.left, successor.val);
            // 将该元素替换过去
            successor.right = root.right;
            successor.left = root.left;
            return successor;
        }
        return root;
    }
}
