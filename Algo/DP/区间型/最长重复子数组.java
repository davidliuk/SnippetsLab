// lc718
// dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀
// 如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
// 答案即为所有 dp[i][j] 中的最大值
public int findLength(int[] A, int[] B) {
    int n = A.length, m = B.length;
    int[][] dp = new int[n + 1][m + 1];
    int ans = 0;
    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
            ans = Math.max(ans, dp[i][j]);
        }
    }
    return ans;
}
