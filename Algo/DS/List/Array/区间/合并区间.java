// lc56
public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
        return new int[0][2];
    }
    
    Arrays.sort(intervals, (interval1, interval2) -> {
        if (interval1[0] - interval2[0] == 0) {
            // 终点降序
            return - interval1[1] + interval2[1];
        }
        // 起点升序
        return interval1[0] - interval2[0];
    });
    
    List<int[]> merged = new ArrayList<int[]>();
    merged.add(intervals[0]);
    int last = intervals[0][1];
    for (int i = 1; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        if (last < left) {
            // 完全不相交
            merged.add(intervals[i]);
            last = right;
        } else if (last < right) {
            // 相交但不覆盖，更新
            merged.get(merged.size() - 1)[1] = right;
            last = right;
        }
    }
    
    return merged.toArray(new int[merged.size()][]);
}

// or 省略last（不推荐，因为写法不统一且书写麻烦了）
public int[][] merge(int[][] intervals) {
    if (intervals.length == 0) {
        return new int[0][2];
    }
    
    Arrays.sort(intervals, (interval1, interval2) -> {
        if (interval1[0] - interval2[0] == 0) {
            // 终点降序
            return - interval1[1] + interval2[1];
        }
        // 起点升序
        return interval1[0] - interval2[0];
    });
    
    List<int[]> merged = new ArrayList<int[]>();
    merged.add(intervals[0]);
    for (int i = 1; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        if (merged.get(merged.size() - 1)[1] < left) {
            // 完全不相交
            merged.add(intervals[i]);
        } else if (merged.get(merged.size() - 1)[1] < right) {
            // 相加但不覆盖，更新
            merged.get(merged.size() - 1)[1] = right;
        }
    }
    
    return merged.toArray(new int[merged.size()][]);
}

