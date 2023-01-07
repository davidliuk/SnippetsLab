// 排序矩阵，下一行完全比上一行大
// 二维坐标转换一维坐标
// x, y -> x * m + y
// index -> x = index / m, y = index % m
boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 ||
        matrix[0] == null || matrix[0].length == 0) {
        return false;
    }
    
    int n = matrix.length, m = matrix[0].length;
    int start = 0, end = n * m - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (get(matrix, mid) < target) {
            start = mid;
        } else {
            end = mid;
        }
    }
    
    if (get(matrix, start) == target) {
        return true;
    }
    if (get(matrix, end) == target) {
        return true;
    }
    
    return false;
}

int get(int[][] matrix, int index) {
    int x = index / matrix[0].length;
    int y = index % matrix[0].length;
    return matrix[x][y];
}