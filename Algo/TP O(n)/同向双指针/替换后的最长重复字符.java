// lc 424
public int characterReplacement(String s, int k) {
    if (s == null) {
        return 0;
    }

    int j = 0, answer = 0, maxFreq = 0;
    int[] counters = new int[26];
    for (int i = 0; i < s.length(); i++) {
        while(j < s.length() && j - i - maxFreq <= k) {
            counters[s.charAt(j) - 'A']++;
            maxFreq = Math.max(maxFreq, counters[s.charAt(j) - 'A']);
            j++;
        }

        if (j - i - maxFreq > k) {
            answer = Math.max(answer, j - i - 1);
        } else {
            answer = Math.max(answer, j - i);
        }

        counters[s.charAt(i) - 'A']--;
        maxFreq = getMaxFreq(counters);
    }

    return answer;
}

private int getMaxFreq(int[] counters) {
    int maxFreq = 0;
    for (int i = 0; i < 26; i++) {
        maxFreq = Math.max(maxFreq, counters[i]);
    }
    return maxFreq;
}
