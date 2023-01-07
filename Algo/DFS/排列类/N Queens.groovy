// 入口函数
public List<List<String>> solveNQueens(int n) {
    List<List<String>> results = new ArrayList();
    if (n<= 0) {
        return results;
    }
    
    dfs(n, new ArrayList(), results);
    
    return results;
}

// 搜索函数
public void dfs(
    int n,
    List<Integer> cols,
    List<List<String>> results
) {
    if (cols.size() == n) {
        // 打印函数
        results.add(Draw(cols));
        return;
    }
    
    for (int colIndex = 0; colIndex < n; colIndex++) {
        // 判断函数
        if (!isValid(cols, colIndex)) {
            continue;
        }
        cols.add(colIndex);
        dfs(n, cols, results);
        cols.remove(cols.size() - 1);
    }
}

// 判断函数
boolean isValid(List<Integer> cols, int col) {
    int row = cols.size();
    for (int rowIndex = 0; rowIndex < row; rowIndex++) {
        int colIndex = cols.get(rowIndex);
        if (colIndex == col) {
            return false;
        }
        if (colIndex + rowIndex == col + row) {
            return false;
        }
        if (colIndex - rowIndex == col - row) {
            return false;
        }
    }
    return true;
}

// 打印函数
List<String> Draw(List<Integer> cols) {
    int n = cols.size();
    List<String> result = new ArrayList();
    for (int i = 0; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(j == cols.get(i)? 'Q': '.');
        }
        result.add(sb.toString());
    }
    return result;
}
