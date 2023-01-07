// 只要数值，不需要位置
// 此时更推荐：双指针，因为可以直接拿来做follow up
public List<Integer> twoSum(int[] nums, int start, int target) {
    // 左右指针
    int left = start, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        // 根据 sum 和 target 的比较，移动左右指针
        if (sum == target) {
            return Arrays.asList(nums[left], nums[right]);
            // 如果需要修改，且想变成jua，外面再加一层new ArrayList
        }
        if (sum < target) {
            left++;
        } else {
            // sum > target
            right--;
        }
    }
    
    return new ArrayList<>();
}

public int[] twoSum(int[] nums, int target) {
    // nums 数组必须有序
    Arrays.sort(nums);
    // 左右指针
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        // 根据 sum 和 target 的比较，移动左右指针
        if (sum == target) {
            return new int[]{nums[left], nums[right]};
        }
        if (sum < target) {
            left++;
        } else {
            // sum > target
            right--;
        }
    }
    
    return new int[0];
}

// 稍作优化，一次多跳过一些
public int[] twoSum(int[] nums, int target) {
    // nums 数组必须有序
    Arrays.sort(nums);
    // 左右指针
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = nums[left] + nums[right];
        int low = nums[left], high = nums[right];
        // 根据 sum 和 target 的比较，移动左右指针
        if (sum == target) {
            return new int[]{nums[left], nums[right]};
        }
        if (sum < target) {
            while (left < right && nums[left] == low) left++;
        } else {
            while (left < right && nums[right] == high) right--;
        }
    }
    
    return new int[0];
}

