public int LIS(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    
    int n = nums.length;
    // dp[i]是以i为结尾的最长LIS的长度
    int[] dp = new int[n];
    
    for (int i = 0; i < n; i++) {
        dp[i] = 1;
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }
    
    int max = 0;
    for (int i = 0; i < n; i++) {
        max = Math.max(max, dp[i]);
    }
    
    return max;
}


public ArrayList<Integer> LIS(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    
    int n = nums.length;
    // dp[i]是以i为结尾的最长LIS的长度
    int[] dp = new int[n];
    // prev[i]是跳过来的位置
    int[] prev = new int[n];
    
    for (int i = 0; i < n; i++) {
        dp[i] = 1;
        prev[i] = -1
    }
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1;
                prev[i] = j;
            }
        }
    }
    
    int max = 0, last = -1;
    for (int i = 0; i < n; i++) {
        if （dp[i] > max) {
            max = dp[i];
            last = i;
        }
    }
    
    ArrayList<Integer> path = new ArrayList<Integer>();
    while (last != -1) {
        path.add(nums[last]);
        last = prev[last];
    }
    
    return path;
}