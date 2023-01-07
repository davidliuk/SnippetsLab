// lc1197
int[] dx = new int[]{-2, -1, -1, -2, 2, 1, 1, 2};
int[] dy = new int[]{-1, -2, 2, 1, 1, 2, -2, -1};

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public int minKnightMoves(int x, int y) {
    if (x == 0 && y == 0) {
        return 0;
    }

    Queue<Point> forwardQueue = new ArrayDeque<>();
    Queue<Point> backwardQueue = new ArrayDeque<>();
    boolean[][] forwardSet = new boolean[1201][1201];
    boolean[][] backwardSet = new boolean[1201][1201];

    forwardQueue.offer(new Point(0, 0));
    backwardQueue.offer(new Point(x, y));
    forwardSet[600][600] = true;
    backwardSet[600 + x][600 + y] = true;
    
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
    Queue<Point> queue,
    boolean[][] set,
    boolean[][] oppsiteSet
) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        Point point = queue.poll();
        int x = point.x;
        int y = point.y;
        for (int j = 0; j < 8; j++) {
            int newX = x + dx[j];
            int newY = y + dy[j];
            if (set[600 + newX][600 + newY]) {
                continue;
            }
            if (oppsiteSet[600 + newX][600 + newY]) {
                return true;
            }
            queue.offer(new Point(newX, newY));
            set[600 + newX][600 + newY] = true;
        }
    }

    return false;
}
