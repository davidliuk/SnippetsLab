// 面试题 16.02. 
class WordsFrequency {

    Map<String, Integer> occurrences;

    public WordsFrequency(String[] book) {
        occurrences = new HashMap<>(book.length);
        for (String word : book) {
            occurrences.put(word, occurrences.getOrDefault(word, 0) + 1);
        }
    }
    
    public int get(String word) {
        return occurrences.getOrDefault(word, 0);
    }
}
