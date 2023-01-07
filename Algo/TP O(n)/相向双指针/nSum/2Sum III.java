// 返回所有不同的数字组合
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

vector<vector<int>> twoSumTarget(vector<int>& nums, int target) {
    // nums 数组必须有序
    sort(nums.begin(), nums.end());
    int lo = 0, hi = nums.size() - 1;
    vector<vector<int>> res;
    while (lo < hi) {
        int sum = nums[lo] + nums[hi];
        int left = nums[lo], right = nums[hi];
        if (sum < target) {
            while (lo < hi && nums[lo] == left) lo++;
        } else if (sum > target) {
            while (lo < hi && nums[hi] == right) hi--;
        } else {
            res.push_back({left, right});
            while (lo < hi && nums[lo] == left) lo++;
            while (lo < hi && nums[hi] == right) hi--;
        }
    }
    return res;
}