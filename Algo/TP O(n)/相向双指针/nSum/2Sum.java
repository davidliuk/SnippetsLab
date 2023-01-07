// lc1
// 并返回它们的数组下标，只会对应一个答案
// 相向双指针
public int[] twoSum(int[] nums, int target) {
    int[][] pos = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        pos[i][0] = nums[i];
        pos[i][1] = i;
    }
    // nums 数组必须有序
    Arrays.sort(pos, (a, b) -> a[0] - b[0]);
    // 左右指针
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int sum = pos[left][0] + pos[right][0];
        // 根据 sum 和 target 的比较，移动左右指针
        if (sum == target) {
            return new int[]{pos[left][1], pos[right][1]};
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


// 哈希表
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> num2index = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; ++i) {
        if (num2index.containsKey(target - nums[i])) {
            return new int[]{num2index.get(target - nums[i]), i};
        }
        num2index.put(nums[i], i);
    }
    return new int[0];
}
