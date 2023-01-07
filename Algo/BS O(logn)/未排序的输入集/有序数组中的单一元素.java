// lc 540
// 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
public int singleNonDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
        return 0;
    }

    int start = 0, end = nums.length - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (!check(nums, mid)) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }

    return nums[start];
}

// 正确的情况，就是偶数位和它后一位相同（从0开始算的偶数位）
boolean check(int[] nums, int index) {
    int offset = index % 2 == 0? 1: -1;
    return nums[index] == nums[index + offset];
}
