// lc912
// 堆排默认是排出来相反的，如大根堆排出来的是正序，小根堆排出来的是倒序，所以这里less这里取了反操作
// Onlogn, O1
public int[] sortArray(int[] nums) {
    // 从数组建堆，On
    heapify(nums);
    // 每次把堆顶元素放到末尾，再让size缩小一位
    for (int size = nums.length - 1; size > 0; size--) {
        swap(nums, 0, size);
        // 让 heap[0] 下沉到正确位置
        sink(nums, 0, size);
    }

    return nums;
}

private void heapify(int[] nums) {
    // 因为是交换，所以只需要把上面一半sink了，整个nums就合法了
    for (int i = (nums.length >>> 1) - 1; i >= 0; i--)
        sink(nums, i, nums.length);
}

private void sink(int[] heap, int x, int size) {
    // 如果沉到堆底，就沉不下去了
    while (left(x) < size) {
        // 先假设左边节点较大
        int child = left(x);
        // 如果右边节点存在，比一下大小
        if (right(x) < size && !less(heap, child, right(x)))
            child = right(x);
        // 结点 x 比俩孩子都大，就不必下沉了，已经到目的位置
        if (!less(heap, child, x))
            break;
        // 否则，不符合最大堆的结构，下沉 x 结点
        swap(heap, x, child);
        x = child;
    }
}

private void swap(int[] heap, int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
}

// heap[i] 是否比 heap[j] 小？ 这里可以调，来提高拓展性
private boolean less(int[] heap, int i, int j) {
    return heap[i] - heap[j] > 0;
}

// 父节点的索引
int parent(int root) {
    // 防止root=0, root-1=-1这时候直接右移会出问题
    return (root - 1) >>> 1;
}

// 左孩子的索引
int left(int root) {
    return root * 2 + 1;
}

// 右孩子的索引
int right(int root) {
    return root * 2 + 2;
}
