List<List<int>> permutation(int[] nums) {
    List<List<Integer>> results = new ArrayList();
    if (nums == null || nums.length == 0) {
        return results;
    }
    
    dfs(nums, 0, new ArrayList(), results);
}

void dfs(
    int[] nums,
    int startIndex,
    List<Integer> result,
    List<List<Integer>> results
) {
    results.add(new ArrayList(result));
    
    for (int i = startIndex; i < nums.length; i++) {
        result.add(nums[i]);
        dfs(nums, i + 1, result, results);
        result.remove(result.size() - 1);
    }
}
