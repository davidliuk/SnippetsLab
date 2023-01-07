// java的队列用ArrayDeque，比较快，不需要距离的时候Distance可以用hashset vistied代替
public void bfs(Node node) {
    Queue<Node> queue = new ArrayDeque<>();
    HashMap<Node, Integer> distance = new HashMap<>();
    
    queue.offer(node);
    distance.set(node, 0);
    
    while (!queue.isEmpty()) {
        // 队列内为当前层的所有节点，此时记录下队列大小对整层进行遍历
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Node node = queue.poll();
            for (Node neighbor: node.getNeighbors()) {
                if (distance.containKeys(neighbor)) {
                    continue;
                }
                
                queue.offer(neighbor);
                distance.set(neighbor, distance.get(node) + 1);
            }
        }
        // 此处加对整层的操作
    }
}