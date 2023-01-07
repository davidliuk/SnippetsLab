// lc567
// Om+n, OΣ, Σ是字符集，这道题中的字符集是小写字母，∣Σ∣=26。
public boolean checkInclusion(String s1, String s2) {
    // 可以替换成一个长度为26的数组，这样可以彻底说是O1空间复杂度了
    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
        char c = s1.charAt(i);
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    int start = 0;
    while (right < s2.length()) {
        char c = s2.charAt(right);
        right++;
        if (need.containsKey(c)) {
            need.put(c, need.get(c) - 1);
            if (need.get(c).equals(0)) {
                valid++;
            }
        }

        while (right - left >= s1.length()) {
            if (valid == need.size()) {
                start = left;
                return true;
            }

            char d = s2.charAt(left);
            left++;
            if (need.containsKey(d)) {
                if (need.get(d).equals(0)) {
                    valid--;
                }
                need.put(d, need.get(d) + 1);
            }
        }
    }

    return false;
}
