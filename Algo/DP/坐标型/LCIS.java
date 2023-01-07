// 二维上的连续的CIS
int longestContinousIncreasingSubsequence(int[][] matrix) {
    if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0) {
        return 0;
    }
    
    int n = matrix.length, m = matrix[0].length;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    List<List<Integer>> points = new ArrayList();
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            points.add(Arrays.asList(i, j, matrix[i][j]));
        }
    }
    
    // 将所有的点，从小到大排序
    points.sort((p1, p2) -> Integer.compare(p1.get(2), p2.get(2)));
    
    int[][] dp = new int[n][m];
    
    for (int i = 0; i < n; i++) {
        int x = points.get(i).get(0);
        int y = points.get(i).get(1);
        
        // 至少长度为1，即自己
        dp[i][j] = 1;
        
        for (int j = 0; j < 4; j++) {
            int prevX = x - dx[j];
            int prevY = y - dy[j];
            
            if (prevX < 0 || prevX >= n || 
                prevY < 0 || prevY >= m) {
                continue;
            }
            
            if (matrix[x][y] > matrix[prevX][prevY]) {
                dp[i][j] = Math.max(dp[i][j], dp[prevX][prevY] + 1);
            }
        }

    }
    
    int longest = 0
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            longest = Math.max(longest, dp[i][j]);
        }
    }
    
    return longest;
}