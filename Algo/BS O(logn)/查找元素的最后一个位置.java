int searchLast(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] <= target) {
            start = mid;
        } else {
            end = mid;
        }
    }

    if (nums[end] == target) {
        return end;
    }
    if (nums[start] == target) {
        return start;
    }
    return -1;
}