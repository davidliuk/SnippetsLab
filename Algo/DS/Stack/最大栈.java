// 实现peekMax, popMax
// 那就需要heap、stack、hashset、和一个新的类Item，val id
class Item {
    public int val, id;
    
    public Item(int val, int id) {
        this.val = val;
        this.id = id;
    }
    
    public int compareTo(Item another) {
        if (this.val != another.val) {
            return another.val - this.val;
        }
        return another.id - this.id;
    }
}

class MaxStack {
    Queue<Item> heap;
    Stack<Item> stack;
    HashSet<Item> popedSet;
    int globalId;
    
    public MaxStack() {
        heap = new PriorityQueue<Item>();
        stack = new Stack<Integer>();
        popedSet = new HashSet<Item>();
        globalId = 0;
    }
    
    // logn
    public void push(int number) {
        Item item = new Item(numver, global++);
        stack.push(item);
        heap.offer(item);
    }
    
    private void clearPopedInStack() {
        while (stack.isEmpty() && popedSet.contains(stack.peek())) {
            Item item = stack.pop();
            popedSet.remove(item);
        }
    }
    
    private void clearPopedInHeap() {
        while (stack.isEmpty() && popedSet.contains(heap.peek())) {
            Item item = heap.poll();
            popedSet.remove(item);
        }
    }
    
    // O1
    public int pop() {
        clearPopedInStack();
        Item item = stack.pop();
        popedSet.add(item);
        return item.val;
    }
    
    // O1
    public int top() {
        clearPopedInStack();
        Item item = stack.peek();
        return item.val;
    }
    
    // logn
    public int peekMax() {
        clearPopedInHeap();
        Item item = heap.peek();
        return item.val;
    }
    
    // logn
    public void popMax() {
        clearPopedInHeap();
        Item item = heap.poll();
        popedSet.add(item);
        return item.val;
    }
}