public List<List<String>> findLadders(
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
            break;
        }
        
        distance++;
        if (extendQueue(backwardQueue, backwardSet, forwardSet, graph)) {
            break;
        }
    }

    List<List<String>> results = new ArrayList();
    Set<String> visited = new HashSet();
    visited.add(beginWord);
    List<String> result = new ArrayList();
    result.add(beginWord);
    dfs(distance, beginWord, endWord, graph, visited, result, results, new HashMap<String, Integer>());
    
    return results;
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
    nextWordSet.remove(word);
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

// 加了记忆化
public boolean dfs(
    int depth,
    String beginWord, 
    String endWord, 
    HashMap<String, Set<String>> graph,
    Set<String> visited,
    List<String> result,
    List<List<String>> results,
    HashMap<String, Integer> memo
) {
    if (result.size() > depth) {
        return false;
    }
    if (memo.containsKey(beginWord) && result.size() >= memo.get(beginWord)) {
        return false;
    }
    if (beginWord.equals(endWord)) {
        results.add(new ArrayList(result));
        return true;
    }
    
    boolean flag = false;
    for (String word: graph.get(beginWord)) {
        if (visited.contains(word)) {
            continue;
        }
        result.add(word);
        visited.add(word);
        flag = dfs(depth, word, endWord, graph, visited, result, results, memo) || flag;
        result.remove(result.size() - 1);
        visited.remove(word);
    }
    if (!flag) {
        int level = memo.getOrDefault(beginWord, result.size());
        memo.put(beginWord, Math.min(level, result.size()));
    }
    return flag;
}