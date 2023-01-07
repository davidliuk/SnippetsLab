class MinStack {
    Stack<Integer> stack, minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int number) {
        stack.push(number);
        if (minStack.empty() || number < minStack.peek()) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public int pop() {
        minStack.pop();
        return stack.pop();
    }
    
    public void min() {
        return minStack.peek();
    }
}

// 可优化的空间，最小值发生变化的时候更新（如果push的等于min，也push一个min到minStack，避免最小值重复的情况）
// pop的时候判断stack顶和minStack顶一样，如果一样则把minStack顶pop，否则不变
class MinStack {
    Stack<Integer> stack, minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int number) {
        stack.push(number);
        if (minStack.empty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }
    
    public int pop() {
        int number = stack.pop();
        if (number == minStack.peek()) {
            minStack.pop();
        }
        return number;
    }
    
    public void min() {
        return minStack.peek();
    }
}