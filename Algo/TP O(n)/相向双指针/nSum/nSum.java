public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    // 递归调用
    return nSum(nums, 4, 0, target);
}

private List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
    List<List<Integer>> result = new ArrayList<>();
    // 递归出口
    if (n < 2 || nums.length < n) {
        return result;
    }
    if (n == 2) {
        return twoSumTarget(nums, start, target);
    }
    
    // 递归拆解
    for (int i = start; i < nums.length; i++) {
        int num = nums[i];
        result.addAll(nSum(nums, n - 1, i + 1, target - num).stream()
                .peek(list -> list.add(num))
                .collect(Collectors.toList()));
        // 等价于如下
//         List<List<Integer>> sub = nSum(nums, n - 1, i + 1, target - num);
//         for (List<Integer> s : sub) {
//             s.add(num);
//             result.add(s);
//         }
        while (i < nums.length && nums[i] == nums[i + 1]) i++;
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
