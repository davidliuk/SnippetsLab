// 01背包
public int lastStoneWeightII(int[] stones) {
    if (stones == null || stones.length == 0) {
        return 0;
    }

    int sum = 0;
    for (int stone: stones) {
        sum += stone;
    }

    int n = stones.length, m = sum / 2;
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
            if (j >= stones[i - 1]) {
                dp[i][j] = Math.max(
                    dp[i - 1][j],
                    dp[i - 1][j - stones[i - 1]] + stones[i - 1]
                );
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return sum - 2 * dp[n][m];
}