// lc253
public boolean canAttendMeetings(int[][] intervals) {
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
    
    int ans = 0;
    int last = intervals[0][1];
    for (int i = 1; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        // 相交或覆盖
        if (last >= left) {
            ans++;
        }
        // 完全不相交
        last = right;
    }
    
    return ans;
}