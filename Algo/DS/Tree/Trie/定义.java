class TrieNode {
    // 儿子结点，（可以不存）
    public Map<Character, TrieNode> children;
    // 根节点到该节点是否是一个单词
    public boolean isWord;
    // 根节点到该节点的单词是什么，（可以不存）
    public String word;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
        word = null;
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public TrieNode getRoot() {
        return root;
    }
    
    // O(L)
    public void insert(String word) {
        // 指针node从根节点开始
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                node.children.put(letter, new TrieNode());
            }
            node = node.children.get(letter);
        }
        node.isWord = true;
        node.word = word;
    }
    
    // O(L)
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return node.isWord;
    }
    
    // O(L)
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char letter = prefix.charAt(i);
            if (!node.children.containsKey(letter)) {
                return false;
            }
            node = node.children.get(letter);
        }
        return true;
    }
}

class WordDictionary {
    Trie trie;
    
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return dfs(trie.getRoot(), word, 0);
    }
    
    boolean dfs(TrieNode root, String word, int index) {
        if (index == word.length) {
            return root.isWord;
        }
        
        char letter = word.charAt(index);
        if (letter == '.') {
            for (Character child: root.children.keySet()) {
                if (dfs(root.children.get(child), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
        if (root.children.containsKey(letter)) {
            return dfs(root.children.get(child), word, index + 1);
        }
        return false;
    }
}
