// O(nm), O(m)
int backPack(int[] A, int[] V, int m) {
    if (A == null || A.length == 0) {
        return 0;
    }
    
    int n = A.length;
    int[] dp = new int[m + 1];
    
    for (int i = 1; i <= n; i++) {
        // 和01背包唯一的区别之处，可以由同一层的物品导出
        // 从小往大枚举，大的可以利用小的结果
        for (int j = 0; j <= m; j++) {
            if (j >= A[i - 1]) {
                dp[j] = Math.max(
                    dp[j],
                    dp[j - A[i - 1]] + V[i - 1]
                );
            }
        }
    }
    
    return dp[m];
}

// O(nm)
int backPack(int[] A, int[] V, int m) {
    if (A == null || A.length == 0) {
        return 0;
    }
    
    int n = A.length;
    int[][] dp = new int[n + 1][m + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (j >= A[i - 1]) {
                dp[i][j] = Math.max(
                    dp[i - 1][j],
                    // 和01背包唯一的区别之处，可以由同一层的物品导出
                    dp[i][j - A[i - 1]] + V[i - 1]
                );
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    
    return dp[n][m];
}

// 老思路
// O(nm2)
int backPack(int[] A, int[] V, int m) {
    if (A == null || A.length == 0) {
        return 0;
    }
    
    int n = A.length;
    int[][] dp = new int[n + 1][m + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            for (int count = 0; count <= j / A[i]; count++) {
                dp[i][j] = Math.max(
                    dp[i][j],
                    dp[i - 1][j - count * A[i]] + count * A[i]
                );
            }
        }
    }
    
    return dp[n][m];
}
