// lc80
// 有序数组，使得出现次数超过两次的元素只出现两次
// 推荐写法，保持统一
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
        return n;
    }
    // 维护 nums[0..slow] 无重复超两次
    // “头”可能被删，所以slow比fast靠前一个，类似dummy
    int slow = 2 - 1, fast = 2;
    while (fast < n) {
        if (nums[slow - 1] != nums[fast]) {
            ++slow;
            nums[slow] = nums[fast];
        }
        fast++;
    }
    return slow + 1;
}

// lc80
public int removeDuplicates(int[] nums) {
    int n = nums.length;
    if (n <= 2) {
        return n;
    }
    // 维护 nums[0..slow) 无重复超两次
    int slow = 2, fast = 2;
    while (fast < n) {
        if (nums[slow - 2] != nums[fast]) {
            nums[slow] = nums[fast];
            ++slow;
        }
        fast++;
    }
    return slow;
}
