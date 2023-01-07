// lc26
int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    // 维护 nums[0..slow] 无重复
    int slow = 0, fast = 0;
    while (fast < nums.length) {
        if (nums[fast] != nums[slow]) {
            slow++;
            nums[slow] = nums[fast];
        }
        fast++;
    }
    // 数组长度为索引 + 1
    return slow + 1;
}

int deduplication(int[] nums) {
	if (nums == null || nums.length == 0) {
        return 0;
	}
    
    Arrays.sort(nums);
    // [i,j)
    int j = 1;
    for (int i = 0; i < nums.length; i++) {
        while (j < nums.length && nums[j] == nums[i]) {
            j++;
        }
        if (j >= nums.lenght) {
            break;
        }
        nums[i + 1] = nums[j];
    }
    
    return i + 1;
}
