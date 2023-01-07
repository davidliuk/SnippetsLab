// lc986
public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    int n = firstList.length, m = secondList.length;
    int i = 0, j = 0;
    List<int[]> result = new ArrayList<>();
    
    while (i < n && j < m) {
        int left1 = firstList[i][0], right1 = firstList[i][1];
        int left2 = secondList[j][0], right2 = secondList[j][1];
        // 两个区间存在交集
        if (right2 >= left1 && right1 >= left2) {
            result.add(new int[]{Math.max(left1, left2), Math.min(right1, right2)});
        }
        
        // 指针前进
        if (right2 < right1) {
            j += 1;
        } else {
            i += 1;
        }
    }

    return result.toArray(new int[result.size()][]);
}

# A, B 形如 [[0,2],[5,10]...]
def intervalIntersection(A, B):
    i, j = 0, 0 # 双指针
    res = []
    while i < len(A) and j < len(B):
        a1, a2 = A[i][0], A[i][1]
        b1, b2 = B[j][0], B[j][1]
        # 两个区间存在交集
        if b2 >= a1 and a2 >= b1:
            # 计算出交集，加入 res
            res.append([max(a1, b1), min(a2, b2)])
        # 指针前进
        if b2 < a2: j += 1
        else:       i += 1
    return res