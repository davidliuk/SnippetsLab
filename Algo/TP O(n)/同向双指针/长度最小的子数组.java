// lc 209
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
public int minSubArrayLen(int threshold, int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    
    int j = 0, answer = Integer.MAX_VALUE, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        while (j < nums.length && sum < threshold) {
            sum += nums[j];
            j++;
        }
        
        if (sum >= threshold) {
            answer = Math.min(answer, j - i);
        }
        sum -= nums[i];
    }

    if (answer == Integer.MAX_VALUE) {
        return 0;
    }
    return answer;
}