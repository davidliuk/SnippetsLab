// lc438
public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> need = new HashMap<>();
    for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        need.put(c, need.getOrDefault(c, 0) + 1);
    }

    int left = 0, right = 0;
    int valid = 0;
    List<Integer> start = new ArrayList<>();
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        if (need.containsKey(c)) {
            need.put(c, need.get(c) - 1);
            if (need.get(c).equals(0)) {
                valid++;
            }
        }

        while (right - left >= p.length()) {
            if (valid == need.size()) {
                start.add(left);
            }

            char d = s.charAt(left);
            left++;
            if (need.containsKey(d)) {
                if (need.get(d).equals(0)) {
                    valid--;
                }
                need.put(d, need.get(d) + 1);
            }
        }
    }

    return start;
}
