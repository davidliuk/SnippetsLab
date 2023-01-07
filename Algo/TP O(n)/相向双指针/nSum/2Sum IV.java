// 返回所有不同的坐标组合
public List<int[]> twoSum(int[] nums, int target) {
    int[][] pos = new int[nums.length][2];
    for (int i = 0; i < nums.length; i++) {
        pos[i][0] = nums[i];
        pos[i][1] = i;
    }
    // nums 数组必须有序
    Arrays.sort(pos, (a, b) -> a[0] - b[0]);
    // 左右指针
    int left = 0, right = nums.length - 1;
    List<int[]> result = new ArrayList<>();
    while (left < right) {
        int sum = pos[left][0] + pos[right][0];
        int low = pos[left][0], high = pos[right][0];
        // 根据 sum 和 target 的比较，移动左右指针
        if (sum == target) {
            result.add(new int[]{pos[left][1], pos[right][1]});
            while (left < right && nums[left] == low) {
                left++;
                result.add(new int[]{pos[left][1], pos[right][1]});
            }
            while (left < right && nums[right] == high) {
                right--;
                result.add(new int[]{pos[left][1], pos[right][1]});
            }
        }
        if (sum < target) {
            while (left < right && nums[left] == low) left++;
        } else {
            while (left < right && nums[right] == high) right--;
        }
    }
    
    return new int[0];
}

public List<int[]> twoSumTarget(int[] nums, int target) {
    // nums 数组必须有序
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    List<int[]> result = new ArrayList<>();
    while (left < right) {
        int sum = nums[left] + nums[right];
        int low = nums[left], high = nums[right];
        if (sum == target) {
            result.add(new int[]{low, high});
            while (left < right && nums[left] == low) left++;
            while (left < right && nums[right] == high) right--;
        }

        if (sum < target) {
            while (left < right && nums[left] == low) left++;
        } else {
            while (left < right && nums[right] == high) right--;
        }
    }

    return result;
}