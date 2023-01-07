// 固定窗口大小为k
int[] winSum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return new int[]{}
    }
    if (k == 0) {
        return new int[nums.length];
    }
    
    int[] result = new int[nums.length - k + 1];
    int j = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        while (j < nums.length && j - i < k) {
            sum += nums[j];
            j++;
        }
        if (j - i == k) {
            results[i] = sum;
        }
        sum -= nums[i];
    }
    
    return results;
}