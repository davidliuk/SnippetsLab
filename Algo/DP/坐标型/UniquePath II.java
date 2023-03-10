class Grid {
    static int OBSTACLE = 1;
    static int SPARE = 0;
}

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0) {
        return 0;
    }
    
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    for (int i = 0; i < m; i++) {
        if (obstacleGrid[i][0] == Grid.OBSTACLE) {
            break;
        }
        dp[i][0] = 1;
    }
    for (int j = 0; j < n; j++) {
        if (obstacleGrid[0][j] == Grid.OBSTACLE) {
            break;
        }
        dp[0][j] = 1;
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[i][j] == Grid.OBSTACLE) {
                continue;
            }
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }

    return dp[m - 1][n - 1];
}