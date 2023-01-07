// 435
// 贪心：每次选不冲突的右边界最小的，所以需要按终点来生序排列
public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals.length == 0) {
        return 0;
    }
    
    Arrays.sort(intervals, (interval1, interval2) -> {
        if (interval1[1] - interval2[1] == 0) {
            // 起点降序
            return - interval1[0] + interval2[0];
        }
        // 终点升序
        return interval1[1] - interval2[1];
    });
    
    int ans = 1;
    int last = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
        int left = intervals[i][0], right = intervals[i][1];
        if (last <= left) {
            // 完全不相交、相切
            // merged.add(intervals[i]);
            last = right;
            ans++;
        }
    }
    
    return intervals.length - ans;
}
