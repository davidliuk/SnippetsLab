// 实际场景中图不可能用邻接矩阵，都在用邻接表
ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    ArrayList<DirectedGraphNode> order = new ArrayList<>();
    // topo 用indegree来判断是否可以入队，其实相当于普通的里面的set
    Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
    for (DirectedGraphNode node: graph) {
        for (DirectedGraphNode neighbor: graph.neighbors) {
            indegree.put(neighbor, indgree.getOrDefault(neighbor, 0) + 1);
        }
    }
    
    Queue<DirectedGraphNode> queue = new PriorityQueue<>();
    for (DirectedGraphNode node: graph) {
        // 如果入度不存在（即入度为0），则没有前驱
        if (!indegree.containsKey(node)) {
            queue,offer(node);
            order.add(node);
        }
    }
    
    while (!queue.isEmpty()) {
        DirectedGraphNode node = queue.poll();
        for (DirectedGraphNode neighbor: graph.neighbors) {
            indegree.put(neighbor, indgree.get(neighbor) - 1);
            if (indegree.get(neighbor) == 0) {
                queue,offer(neighbor);
                order.add(neighbor);
            }
        }
    }
    
    return order;
}