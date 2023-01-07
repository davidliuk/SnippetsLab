// lc138, jz35
// 本质上是一张特殊的出度不大于2的图，或是说类似二叉树
// On,On
// 本质上就是visited表
Map<Node, Node> visited = new HashMap<>();

public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }
    // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
    if (visited.containsKey(head)) {
        return visited.get(head);
    }
    // 克隆节点
    Node node = new Node(head.val);
    visited.put(head, node);
    
    // 二叉树后序遍历
    node.next = copyRandomList(head.next);
    node.random = copyRandomList(head.random);
    
    return node;
}

// 复制图，写起来类似记忆化搜索
private HashMap<Node, Node> visited = new HashMap<>();

public Node cloneGraph(Node node) {
    if (node == null) {
        return node;
    }

    // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
    if (visited.containsKey(node)) {
        return visited.get(node);
    }

    // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
    Node cloneNode = new Node(node.val, new ArrayList());
    // 哈希表存储
    visited.put(node, cloneNode);

    // 遍历该节点的邻居并更新克隆节点的邻居列表
    for (Node neighbor: node.neighbors) {
        cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    
    return cloneNode;
}

// On, O1
// 2, 3不能合并的原因：因为random可能在前也可能在后，所以必须单独跑一趟
public Node copyRandomList(Node head) {
    if (head == null) {
        return null;
    }
    
    // 在原链表上，复制新节点到原节点后
    for (Node node = head; node != null; node = node.next.next) {
        Node nodeNew = new Node(node.val);
        nodeNew.next = node.next;
        node.next = nodeNew;
    }
    // 复制random
    for (Node node = head; node != null; node = node.next.next) {
        Node nodeNew = node.next;
        nodeNew.random = (node.random != null) ? node.random.next : null;
    }
    // 复制next，取出新链表，恢复原链表
    Node headNew = head.next;
    for (Node node = head; node != null; node = node.next) {
        Node nodeNew = node.next;
        nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        node.next = node.next.next;
    }
    return headNew;
}