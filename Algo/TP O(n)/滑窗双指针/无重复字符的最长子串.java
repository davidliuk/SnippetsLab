// lc3
public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> window = new HashMap<>();

    int left = 0, right = 0;
    int result = 0;
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        window.put(c, window.getOrDefault(c, 0) + 1);

        while (window.get(c) > 1) {
            char d = s.charAt(left);
            left++;
            window.put(d, window.get(d) - 1);
        }
        result = Math.max(result, right - left);
    }

    return result;
}

// 九章写法
public int lengthOfLongestSubstring(String s) {
    Set<Character> occ = new HashSet<Character>();
    int n = s.length();
    int j = 0, ans = 0;
    for (int i = 0; i < n; i++) {
        while (j < n && !occ.contains(s.charAt(j))) {
            // 不断地移动右指针
            occ.add(s.charAt(j));
            j++;
        }
        // 第 i 到 j 个字符[i, j)是一个极长的无重复字符子串
        ans = Math.max(ans, j - i);
        occ.remove(s.charAt(i));
    }
    return ans;
}