public int[] searchRange(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return new int[]{-1, -1};
    }
    int left = searchFirst(nums, target);
    int right = searchLast(nums, target);
    return new int[]{left, right};
}

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

int searchFirst(int[] nums, int target) {
    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) {
            start = mid;
        } else {
            end = mid;
        }
    }

    if (nums[start] == target) {
        return start;
    }
    if (nums[end] == target) {
        return end;
    }
    return -1;
}