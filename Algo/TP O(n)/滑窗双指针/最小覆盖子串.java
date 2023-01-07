// lc76
// 推荐如下解法，更加统一，符合模板，直接套模板就可以了
public String minWindow(String s, String t) {
    // 窗口内需要的字符数量的清单
    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
        char c = t.charAt(i);
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    // 记录最小覆盖子串的起始索引及长度
    int start = 0, end = Integer.MAX_VALUE;
    while (right < s.length()) {
        // c 是将移入窗口的字符
        char c = s.charAt(right);
        // 扩大窗口
        right++;
        // 进行窗口内数据的一系列更新
        if (need.containsKey(c)) {
            need.put(c, need.get(c) - 1);
            if (need.get(c).equals(0)) {
                valid++;
            }
        }

        // 判断左侧窗口是否要收缩
        while (valid == need.size()) {
            // 在这里更新最小覆盖子串
            if (right - left < end - start) {
                start = left;
                end = right;
            }
            // d 是将移出窗口的字符
            char d = s.charAt(left);
            // 缩小窗口
            left++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(d)) {
                if (need.get(d).equals(0)) {
                    valid--;
                }
                need.put(d, need.get(d) + 1);
            }
        }
    }
    // 返回最小覆盖子串
    return end == Integer.MAX_VALUE? "": s.substring(start, end);
}

// lc 76
// 九章模板
// 困难
public String minWindow(String s, String t) {
    if (s == null || s.length() == 0 || t == null || t.length() == 0) {
        return "";
    }
    
    Map<Character, Integer> counters = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
        int count = counters.getOrDefault(t.charAt(i), 0);
        counters.put(t.charAt(i), count + 1);
    }
    
    // [i, j)
    int j = 0, flag = counters.size();
    String str = "";
    for (int i = 0; i < s.length(); i++) {
        while(j < s.length() && flag > 0) {
            if (counters.containsKey(s.charAt(j))) {
                int count = counters.get(s.charAt(j));
                counters.put(s.charAt(j), count - 1);
                if (count == 1) {
                    flag--;
                }
            }
            j++;
        }

        char c = s.charAt(i);
        if (flag == 0 && (str == "" || str.length() > j - i)) {
            str = s.substring(i, j);
        }
        if (counters.containsKey(s.charAt(i))) {
            int count = counters.get(s.charAt(i));
            counters.put(s.charAt(i), count + 1);
            if (count == 0) {
                flag++;
            }
        }
    }

    return str;
}

