
int countSubarraysint[] nums, int threshold) {
    if (nums == null || nums.length == 0) {
        return 0;
    }
    
    // [i, j)的和
    int j = 0, answer = 0, sum = 0;
    for (int i = 0; i < nums.length; i++) {
        j = Math.max(j, i + 1);
        while (j < nums.length && sum < threshold) {
            sum += nums[j];
            j++;
        }
        
        answer += j - i;
        sum -= nums[i];
    }
    
    return answer;
}