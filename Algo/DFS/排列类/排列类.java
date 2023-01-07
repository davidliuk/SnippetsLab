// A[], [1, 2, 3] 123 132 321 

// 入口函数
public List<List<Integer>> permutation(int[] nums) {
    List<List<Integer>> results = new ArrayList();
    if (nums == null || nums.length == 0) {
        return results;
    }
    
    dfs(nums, new boolean[nums.length], new ArrayList(), results);
    return results;
}

// 搜索函数
public void dfs(
    int[] nums,
    boolean[] visited,
    List<Integer> result,
    List<List<Integer>> results
) {
    if (result.size() == nums.length) {
        // 打印函数
        results.add(new ArrayList(result));
        return;
    }
    
    for (int i = 0; i < nums.length; i++) {
        // 判断函数
        if (visited[i]) {
            continue;
        }
        result.add(nums[i]);
        visited[i] = true;
        dfs(nums, visited, result, results);
        result.remove(result.size() - 1);
        visited[i] = false;
    }
}
