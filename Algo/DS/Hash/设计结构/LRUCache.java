class ListNode {
    public int key, val;
    public ListNode next;
    
    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class LRUCache {
    // Cache的容量
    private int capacity;
    // 单链表虚拟头结点
    private ListNode dummy;
    // 单链表虚拟头结点 
    private ListNode tail;
    // key到数据节点之前的节点
    private Map<Integer, ListNode> keyToPrev;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyToPrev = new HashMap<Integer, ListNode>();
        dummy = new ListNode(0, 0);
        tail = dummy;
    }
    
    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        
        kick(key);
        
        return tail.val;
    }
    
    public void set(int key, int val) {
        if (keyToPrev.containsKey(key)) {
            kick(key);
            tail.val = val;
            return;
        }
        
        pushBack(new ListNode(key, val));
        if (keyToPrev.size() > capacity) {
            popFront();
        }
    }
    
    private void pushBack(ListNode node) {
        keyToPrev.put(node, tail);
        tail.next = node;
        node.next = null;
        tail = node;
    }
    
    private void popFront() {
        ListNode head = dummy.next;
        dummy.next = head.next;
        keyToPrev.remove(head.key);
        keyToPrev.put(head.next, dummy);
    }
    
    // 把key对应的节点踢到末尾
    private void kick(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode node = prev.next;
        
        if (node == tail) {
            return;
        }
        
        prev.next = node.next;
        keyToPrev.put(node.next.key, prev);
        
        pushBack(node);
    }
    
}