// lc27
// 推荐写法，与前文写法统一
int removeElement(int[] nums, int val) {
    // 维护 nums[0..slow] 无val
    // slow = -1类似dummy，因为0号可能被删
    // 且保证nums一开始无内容
    int slow = -1, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            slow++;
            // 如下地方如果改成swap，则可以直接做移动0
            nums[slow] = nums[fast];
        }
        fast++;
    }
    return slow + 1;
}

int removeElement(int[] nums, int val) {
    // 维护 nums[0..slow) 无val
    int fast = 0, slow = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            nums[slow] = nums[fast];
            slow++;
        }
        fast++;
    }
    return slow;
}

// 保留元素到数组末尾的方法
int removeElement(int[] nums, int val) {
    // 维护 nums[0..slow] 无val
    // slow = -1类似dummy，因为0号可能被删
    // 且保证nums一开始无内容
    int slow = -1, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            slow++;
            // 如下地方如果改成swap，则可以直接做移动0
            // nums[slow] = nums[fast];
            swap(nums, slow, fast);
        }
        fast++;
    }
    return slow + 1;
}