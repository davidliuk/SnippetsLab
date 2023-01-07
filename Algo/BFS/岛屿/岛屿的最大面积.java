int[] dX = {0, 0, 1, -1};
int[] dY = {1, -1, 0, 0};

public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
        return 0;
    }

    int ans = 0;
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] == 0) {
                continue;
            }
            ans = Math.max(ans, bfs(grid, i, j));
        }
    }

    return ans;
}

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

int bfs(
    int[][] grid,
    int x,
    int y
) {
    Queue<Point> queue = new ArrayDeque();
    queue.offer(new Point(x, y));
    int counter = 1;
    grid[x][y] = 0;

    while (!queue.isEmpty()) {
        Point point = queue.poll();
        for (int i = 0; i < 4; i++) {
            int newX = point.x + dX[i];
            int newY = point.y + dY[i];
            if (check(grid, newX, newY)) {
                queue.offer(new Point(newX, newY));
                counter++;
                grid[newX][newY] = 0;
            }
        }
    }

    return counter;
}

boolean check(int[][] grid, int x, int y) {
    if (x < 0 || x >= grid.length) {
        return false;
    }
    if (y < 0 || y >= grid[0].length) {
        return false;
    }
    if (grid[x][y] != 1) {
        return false;
    }
    return true;
}
