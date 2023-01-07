// 已知起点和终点时，可以加速搜索
// 用来搜索距离/步数
// 如果是二维矩阵上的遍历，则set需要用二维数组代替（不然Set不好判断二维坐标对象）
public int bfs(Node start, Node end) {
    Queue<Node> forwardQueue = new ArrayDeque<>();
    Queue<Node> backwardQueue = new ArrayDeque<>();
    Set<Node> forwardSet = new HashSet<>();
    Set<Node> backwardSet = new HashSet<>();
    
    forwardQueue.offer(start);
    forwardSet.set(start);
    backwardQueue.offer(end);
    backwardSet.set(end);
    
    int distance = 0;
    while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
        distance++;
        if (extendQueue(forwardQueue, forwardSet, backwardSet)) {
            return distance;
        }
        
        distance++;
        if (extendQueue(backwardQueue, backwardSet, forwardSet)) {
            return distance;
        }
    }
    
    return -1;
}

boolean extendQueue(
    Queue<Node> queue,
    Set<Node> set,
    Set<Node> oppsiteSet
) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        for (Node neighbor: node.getNeighbors()) {
            if (set.containKeys(neighbor)) {
                continue;
            }
            if (oppsiteSet.containKeys(neighbor)) {
                return true;
            }
            
            set.add(neighbor);
            queue.offer(neighbor);
        }
    }
    
    return false;
}