class Grid {
    static char X = 'X';
    static char O = 'O';
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

int[] dx = new int[]{-1, 1, 0, 0};
int[] dy = new int[]{0, 0, -1, 1};

public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
        return;
    }

    int n = board.length, m = board[0].length;
    boolean[][] unwrapped = new boolean[n][m];

    for (int i = 0; i < n; i++) {
        if (board[i][0] == Grid.O && !unwrapped[i][0]) {
            bfs(board, unwrapped, i, 0);
        }
        if (board[i][m - 1] == Grid.O && !unwrapped[i][m - 1]) {
            bfs(board, unwrapped, i, m - 1);
        }
    }
    for (int j = 0; j < m; j++) {
        if (board[0][j] == Grid.O && !unwrapped[0][j]) {
            bfs(board, unwrapped, 0, j);
        }
        if (board[n - 1][j] == Grid.O && !unwrapped[n - 1][j]) {
            bfs(board, unwrapped, n - 1, j);
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (board[i][j] == Grid.O && !unwrapped[i][j]) {
                board[i][j] = Grid.X;
            }
        }
    }

}

void bfs (
    char[][] board,
    boolean[][] unwrapped,
    int sx, 
    int sy
) {
    Queue<Point> queue = new ArrayDeque<>();
    queue.offer(new Point(sx, sy));
    unwrapped[sx][sy] = true;

    while (!queue.isEmpty()) {
        Point point = queue.poll();
        int x = point.x;
        int y = point.y;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (check(board, unwrapped, newX, newY)) {
                queue.offer(new Point(newX, newY));
                unwrapped[newX][newY] = true;
            }
        }
    }
}

boolean check(
    char[][] board,
    boolean[][] unwrapped,
    int x, 
    int y
) {
    if (x < 0 || x >= board.length) {
        return false;
    }
    if (y < 0 || y >= board[0].length) {
        return false;
    }
    if (board[x][y] == Grid.X) {
        return false;
    }
    if (unwrapped[x][y]) {
        return false;
    }

    return true;
}