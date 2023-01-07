public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return new int[nums.length - k + 1];
    }
    
    int[] result = new int[nums.length - k + 1];
    Deque<Integer> deque = new ArrayDeque<>();
    
    for (int i = 0; i < nums.length; i++) {
        // 单调递减栈
        while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
            deque.pollLast();
        }
        deque.offer(i);
        
        // 从i - k - 1开始计算答案
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        
        // 第i个元素进入窗口
        // 相当于第 i - k + 1 个元素应该离开窗口
        if (i - k + 1 == deque.peekFirst()) {
            deque.pollFirst();
        }
    }
    
    return result;
}
