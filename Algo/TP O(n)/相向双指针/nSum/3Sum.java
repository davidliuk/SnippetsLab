// lc15
public List<List<Integer>> threeSum(int[] nums) {
    if (nums == null || nums.length == 0) {
        return new ArrayList<>();
    }

    return threeSum(nums, 0);
}

public List<List<Integer>> threeSum(int[] nums, int target) {
    // nums 数组必须有序
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        result.addAll(twoSumTarget(nums, i + 1, target - num).stream()
                .peek(list -> list.add(num))
                .collect(Collectors.toList()));
        // 跳过所有与i重的元素（但留一个，因为for循环会往下走一个）
        // 这里写法类似快慢双指针去重，但不完全一样
        // i + 1 < nums.length 等价于链表的p.next != null
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
    }
    
    return result;
}

public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
    // nums 数组必须有序
    // Arrays.sort(nums);
    int left = start, right = nums.length - 1;
    List<List<Integer>> result = new ArrayList<>();
    while (left < right) {
        int sum = nums[left] + nums[right];
        int low = nums[left], high = nums[right];
        if (sum == target) {
            result.add(new ArrayList<>(Arrays.asList(low, high)));
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
