// lc 1918
public int kthSmallestSubarraySum(int[] nums, int k) {
    int min = Integer.MAX_VALUE, sum = 0;
    for (int num: nums) {
        min = Math.min(min, num);
        sum += num;
    }

    int start = min, end = sum;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (check(nums, mid) >= k) {
            end = mid;
        } else {
            start = mid;
        }
    }

    if (k <= check(nums, start)) {
        return start;
    }
    return end;
}

int check(int[] nums, int threshold) {
    int count = 0, sum = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        // 最终记录的<=threshold的总数
        while (sum > threshold) {
            sum -= nums[left];
            left++;
        }
        count += right - left + 1;
    }
    return count;
}