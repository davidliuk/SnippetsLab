// O(nm)
// 特点：第二重是sum
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
                    dp[i - 1][j - A[i - 1]] + V[i - 1]
                );
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    
    return dp[n][m];
}

// O(nm), O(m)
int backPack(int[] A, int[] V, int m) {
    if (A == null || A.length == 0) {
        return 0;
    }
    
    int n = A.length;
    int[] dp = new int[m + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int j = m; j >= 0; j--) {
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