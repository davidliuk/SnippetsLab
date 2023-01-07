// 可待优化为懒加载
int ladderLength(
    String beginWord, 
    String endWord, 
    List<String> wordList
) {
    wordList.add(beginWord);
    Set<String> wordSet = new HashSet<String>(wordList);
    HashMap<String, Set<String>> graph = construct(wordSet);
    
    Queue<String> forwardQueue = new ArrayDeque<>();
    Queue<String> backwardQueue = new ArrayDeque<>();
    Set<String> forwardSet = new HashSet<>();
    Set<String> backwardSet = new HashSet<>();
    
    forwardQueue.offer(beginWord);
    forwardSet.add(beginWord);
    backwardQueue.offer(endWord);
    backwardSet.add(endWord);
    
    int distance = 1;
    while (!forwardQueue.isEmpty() && !backwardQueue.isEmpty()) {
        distance++;
        if (extendQueue(forwardQueue, forwardSet, backwardSet, graph)) {
            return distance;
        }
        
        distance++;
        if (extendQueue(backwardQueue, backwardSet, forwardSet, graph)) {
            return distance;
        }
    }
    
    return 0;
    
}

HashMap<String, Set<String>> construct(
    Set<String> wordSet
) {
    HashMap<String, Set<String>> graph = new HashMap<String, Set<String>>();
    for (String word: wordSet) {
        graph.put(word, getNextWords(word, wordSet));
    }
    
    return graph;
}

Set<String> getNextWords(
    String word, 
    Set<String> wordSet
) {
    Set<String> nextWordSet = new HashSet<String>();
    int wordLength = word.length();
    StringBuilder wordBuilder = new StringBuilder(word);
    for (int i = 0; i < wordLength; i++) {
        for (char c = 'a'; c <= 'z'; c++) {
            char temp = wordBuilder.charAt(i);
            wordBuilder.replace(i, i + 1, "" + c);
            String nextWord = wordBuilder.toString();
            if (wordSet.contains(nextWord)) {
                nextWordSet.add(nextWord);
            }
            wordBuilder.replace(i, i + 1, "" + temp);
        }
    }
    return nextWordSet;
}

boolean extendQueue(
    Queue<String> queue,
    Set<String> set,
    Set<String> oppsiteSet,
    HashMap<String, Set<String>> graph
) {
    int size = queue.size();
    for (int i = 0; i < size; i++) {
        String node = queue.poll();
        for (String neighbor: graph.getOrDefault(node, new HashSet<String>())) {
            if (set.contains(neighbor)) {
                continue;
            }
            if (oppsiteSet.contains(neighbor)) {
                return true;
            }
            
            set.add(neighbor);
            queue.offer(neighbor);
        }
    }
    
    return false;
}