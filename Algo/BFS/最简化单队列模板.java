// 层次关系存在distance数组中
public void bfs(Node node) {
    Queue<Node> queue = new ArrayDeque<>();
    HashMap<Node, Integer> distance = new HashMap<>();
    
    queue.offer(node);
    distance.set(node, 0);
    
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        
        for (Node neighbor: node.getNeighbors()) {
            if (distance.containKeys(neighbor)) {
                continue;
            }
            
            queue.offer(neighbor);
            distance.set(neighbor, distance.get(node) + 1);
        }
    }
}

public void bfs(Node node) {
    Queue<Node> queue = new ArrayDeque<>();
    Set<Node> set = new HashSet<>();
    
    queue.offer(node);
    set.add(node);
    
    while (!queue.isEmpty()) {
        Node node = queue.poll();
        
        for (Node neighbor: node.getNeighbors()) {
            if (distance.containKeys(neighbor)) {
                continue;
            }
            
            queue.offer(neighbor);
            set.add(neighbor);
        }
    }
}