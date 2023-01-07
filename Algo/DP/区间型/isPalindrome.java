
boolean[][] isPalindrome(String s) {
    int n = s.length();
    boolean[][]f = new boolean[n][n];
    for (int i = 0; i < n; ++i) {
        Arrays.fill(f[i], true);
    }
    
    for (int i = n - 1; i >= 0; --i) {
        for (int j = i + 1; j < n; ++j) {
            f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
        }
    }
    
    return f;
}

// 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
int isPalindrome(String s, int i, int j) {
    if (f[i][j]) {
        return f[i][j];
    }
    if (i >= j) {
        return f[i][j] = 1;
    }
    
    return f[i][j] = (s[i] == s[j] ? isPalindrome(s, i + 1, j - 1) : -1);
}
