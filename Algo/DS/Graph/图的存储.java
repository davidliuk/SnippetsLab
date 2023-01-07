

1. 邻接矩阵

二维矩阵

2. 邻接表
    
    无权图写法，存的都是节点编号
    ```java
    List<Integer>[] graph = new ArrayList[n];
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
        graph[i] = new ArrayList<Integer>();
    }

    for (int[] edge: prerequisites) {
        graph[edge[1]].add(edge[0]);
        indegree[edge[0]]++;
    }
    ```

3. 链式前向星

