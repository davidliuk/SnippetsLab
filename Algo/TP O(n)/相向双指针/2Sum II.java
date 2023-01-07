// 返回所有可能的组合
List<List<Integer>> twoSumTarget(int[] nums, int target) {
    // nums 数组必须有序
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    while (left < right) {
        int sum = nums[left] + nums[right];
        int left = nums[left], right = nums[right];
        if (sum < target) {
            while (left < right && nums[left] == left) {
                left++;
            }
        } else if (sum > target) {
            while (left < right && nums[right] == right) {
                right--;
            }
        } else {
            res.add(Arrays.asList(left, right));
            while (left < right && nums[lo] == left) lo++;
            while (left < right && nums[hi] == right) hi--;
        }
    }
    return res;
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
