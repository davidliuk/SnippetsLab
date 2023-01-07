// lc165
// Om+n, O1
// 分割字符串
public int compareVersion(String version1, String version2) {
    int n = version1.length(), m = version2.length();
    int i = 0, j = 0;
    while (i < n || j < m) {
        int x = 0;
        while (i < n && version1.charAt(i) != '.') {
            x = x * 10 + version1.charAt(i) - '0';
            i++;
        }
        i++; // 跳过点号
        int y = 0;
        while (j < m && version2.charAt(j) != '.') {
            y = y * 10 + version2.charAt(j) - '0';
            j++;
        }
        j++; // 跳过点号
        if (x != y) {
            return x > y ? 1 : -1;
        }
    }
    return 0;
}
