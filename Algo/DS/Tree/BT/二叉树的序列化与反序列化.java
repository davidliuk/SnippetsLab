// hard
public String serialize(TreeNode root) {
    return rserialize(root);
}

public TreeNode deserialize(String data) {
    List<String> dataList = new LinkedList<String>(Arrays.asList(data.split(",")));
    return rdeserialize(dataList);
}

public String rserialize(TreeNode root) {
    if (root == null) {
        return "None,";
    }
    
    String str = String.valueOf(root.val) + ",";
    str += rserialize(root.left);
    str += rserialize(root.right);
    
    return str;
}

public TreeNode rdeserialize(List<String> dataList) {
    if (dataList.get(0).equals("None")) {
        dataList.remove(0);
        return null;
    }
    
    TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
    dataList.remove(0);
    root.left = rdeserialize(dataList);
    root.right = rdeserialize(dataList);
    
    return root;
}
