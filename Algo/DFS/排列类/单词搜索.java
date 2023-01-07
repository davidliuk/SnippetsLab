public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0) {
        return word == null || word == "";
    }

    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            visited[i][j] = true;
            if (dfs(board, visited, word, i, j, 0)) {
                return true;
            }
            visited[i][j] = false;
        }
    }

    return false;
}

int[] dx = {0, 0, 1, -1};
int[] dy = {1, -1, 0, 0};

boolean dfs(
    char[][] board,
    boolean[][] visited,
    String word,
    int x,
    int y,
    int k
) {
    if (board[x][y] != word.charAt(k)) {
        return false;
    }
    if (k == word.length() - 1) {
        return true;
    }

    for (int i = 0; i < 4; i++) {
        int newX = x + dx[i];
        int newY = y + dy[i];
        if (check(board, newX, newY)) {
            if (visited[newX][newY]) {
                continue;
            }
            visited[newX][newY] = true;
            boolean flag = dfs(board, visited, word, newX, newY, k + 1);
            visited[newX][newY] = false;
            if (flag) {
                return true;
            }
        }
    }

    return false;
}

boolean check(char[][] board,int x, int y) {
    if (x < 0 || x >= board.length) {
        return false;
    }
    if (y < 0 || y >= board[0].length) {
        return false;
    }
    return true;
}
