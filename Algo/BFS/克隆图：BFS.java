// lc
// bfs based 1
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        HashMap<Node, Node> visited = new HashMap<>();

        // 将题目给定的节点添加到队列
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node node = queue.poll();
            // 遍历该节点的邻居
            for (Node neighbor: node.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 将邻居节点加入队列中
                    queue.offer(neighbor);
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                }
                // 更新当前节点的邻居列表
                visited.get(node).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}

// bfs based 2
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        List<Node> nodes = findAllNodes(node);
        Map<Node, Node> mapping = findMapping(nodes);
        copyNodes(nodes, mapping);

        return mapping.get(node);
    }

    private List<Node> findAllNodes(Node node) {

        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node nextNode: curr.neighbors) {
                if (visited.contains(nextNode)) {
                    continue;
                }
                queue.offer(nextNode);
                visited.add(nextNode);
            }
        }

        return new LinkedList<>(visited);
    }

    private Map<Node, Node> findMapping(List<Node> nodes) {
        Map<Node, Node> mapping = new HashMap<>();
        for (Node node: nodes) {
            mapping.put(node, new Node(node.val));
        }

        return mapping;
    }

    private void copyNodes(List<Node> nodes, Map<Node, Node> mapping) {
        for (Node node: nodes) {
            Node newNode = mapping.get(node);
            for (Node neighbor: node.neighbors) {
                newNode.neighbors.add(mapping.get(neighbor));
            }
        }
    }
    
}
