// LinkedHashMap（其实在文档协调编辑系统里面常用）
class LRUCache {
    // Cache的容量
    private int capacity;
    // key到数据节点之前的节点
    private Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        int val = map.remove(key);
        map.put(key, val);
        return val;
    }
    
    public void put(int key, int val) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, val);
            return;
        }
        
        map.put(key, val);
        if (map.size() > capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}