// lc451
public String frequencySort(String s) {
    Map<Character, Integer> occurrences = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        occurrences.put(s.charAt(i), occurrences.getOrDefault(s.charAt(i), 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    occurrences.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue() - e1.getValue())
        .map(Map.Entry::getKey)
        .forEach(c -> {
            for (int i = 0; i < occurrences.get(c); i++) {
                sb.append(c);
            }
        });

    return sb.toString();
}
