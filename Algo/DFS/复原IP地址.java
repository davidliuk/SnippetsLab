// lc 93 hard
static final int SEG_COUNT = 4;
List<String> ans = new ArrayList<String>();
String[] segments = new String[SEG_COUNT];

public List<String> restoreIpAddresses(String s) {
    dfs(s, 0, 0);
    return ans;
}

public void dfs(String s, int level, int startIndex) {
    if (level == SEG_COUNT) {
        if (startIndex == s.length()) {
            ans.add(String.join(".", segments));
        }
        return;
    }
    
    if (startIndex == s.length()) {
        return;
    }

    // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
    if (s.charAt(startIndex) == '0') {
        segments[level] = "0";
        dfs(s, level + 1, startIndex + 1);
    }
    
    int addr = 0;
    for (int i = startIndex; i < s.length(); ++i) {
        addr = addr * 10 + (s.charAt(i) - '0');
        if (addr <= 0 || addr > 0xFF) {
            break;
        }
        segments[level] = String.valueOf(addr);
        dfs(s, level + 1, i + 1);
    }
}
