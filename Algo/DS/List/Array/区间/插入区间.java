// lc57
public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
        return new int[][]{newInterval};
    }
    
    List<int[]> merged = new ArrayList<int[]>();
    // 可能插到头的前面，所以类似虚拟头节点的处理方式
    int last = -1;
    boolean placed = false;
    for (int i = 0; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        if (!placed && left >= newInterval[0]) {
            merged.add(newInterval);
            last = newInterval[1];
            placed = true;
        }
        if (!placed && right >= newInterval[0]) {
            if (right < newInterval[1]) {
                intervals[i][1] = newInterval[1];
                right = newInterval[1];
            }
            placed = true;
        }
        if (last < left) {
            // 完全不相交
            merged.add(intervals[i]);
            last = right;
        } else if (last < right) {
            // 相加但不覆盖，更新
            merged.get(merged.size() - 1)[1] = right;
            last = right;
        }
    }
    if (!placed) {
        merged.add(newInterval);
    }
    
    return merged.toArray(new int[merged.size()][]);
}

// 空间优化
public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null || intervals.length == 0) {
        return new int[][]{newInterval};
    }
    
    List<int[]> merged = new ArrayList<int[]>();
    // 可能插到头的前面，所以类似虚拟头节点的处理方式
    int last = -1;
    boolean placed = false;
    for (int i = 0; i < intervals.length; ++i) {
        int left = intervals[i][0], right = intervals[i][1];
        if (!placed && left >= newInterval[0]) {
            merged.add(newInterval);
            last = newInterval[1];
            placed = true;
        }
        if (!placed && right >= newInterval[0]) {
            if (right < newInterval[1]) {
                intervals[i][1] = newInterval[1];
                right = newInterval[1];
            }
            placed = true;
        }
        if (last < left) {
            // 完全不相交
            merged.add(intervals[i]);
            last = right;
        } else if (last < right) {
            // 相加但不覆盖，更新
            merged.get(merged.size() - 1)[1] = right;
            last = right;
        }
    }
    if (!placed) {
        merged.add(newInterval);
    }
    
    return merged.toArray(new int[merged.size()][]);
}
