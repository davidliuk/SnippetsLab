// lc283
// 方法一，直接化用
void moveZeroes(int[] nums) {
    // 去除 nums 中的所有 0，返回不含 0 的数组长度
    int p = removeElement(nums, 0);
    // 将 nums[p..] 的元素赋值为 0
    for (; p < nums.length; p++) {
        nums[p] = 0;
    }
}

int removeElement(int[] nums, int val) {
    // 维护 nums[0..slow] 无val
    // slow = -1类似dummy，因为0号可能被删
    // 且保证nums一开始无内容
    int slow = -1, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
    }
    return slow + 1;
}

// 方法二swap版
void moveZeroes(int[] nums) {
    // 去除 nums 中的所有 0
    removeElement(nums, 0);
}

int removeElement(int[] nums, int val) {
    // 维护 nums[0..slow] 无val
    // slow = -1类似dummy，因为0号可能被删
    // 且保证nums一开始无内容
    int slow = -1, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] != val) {
            slow++;
            // nums[slow] = nums[fast];
            swap(nums, slow, fast);
        }
        fast++;
    }
    return slow + 1;
}

void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}