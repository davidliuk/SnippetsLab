// lc1288
// 返回删除了被覆盖的区间以后的值
public int removeCoveredIntervals(int[][] intervals) {
    if (intervals.length == 0) {
        return 0;
    }
    
    Arrays.sort(intervals, (interval1, interval2) -> {
        if (interval1[0] - interval2[0] == 0) {
            // 终点降序
            return - interval1[1] + interval2[1];
        }
        // 起点升序
        return interval1[0] - interval2[0];
    });
    
    int ans = intervals.length;
    int last = intervals[0][1];
    for (int i = 1; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        if (last < left) {
            // 完全不相交
            // merged.add(intervals[i]);
            last = right;
        } else if (last < right) {
            // 相加但不覆盖，更新
            last = right;
        } else {
            // 覆盖，减少
            ans--;
        }
    }
    
    return ans;
}
