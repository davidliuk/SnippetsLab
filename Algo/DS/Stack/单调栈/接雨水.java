// 维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组height 中的元素递减。
// 单调递减栈
public int trap(int[] height) {
    int ans = 0;
    Deque<Integer> stack = new LinkedList<Integer>();
    int n = height.length;
    for (int i = 0; i < n; ++i) {
        while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                break;
            }
            int left = stack.peek();
            int currWidth = i - left - 1;
            int currHeight = Math.min(height[left], height[i]) - height[top];
            ans += currWidth * currHeight;
        }
        stack.push(i);
    }
    return ans;
}