// jz51
// 逆序对，在merge的时候计算，左边的指针右移的时候加右边指针移动数
public int reversePairs(int[] nums) {
    return reversePairs(nums, 0, nums.length - 1, new int[nums.length]);
}

// [start, end]
int reversePairs(int[] A, int start, int end, int[] temp) {
    // 递归出口
    if (start >= end) {
        return 0;
    }
    
    // 递归拆解
    int mid = (end - start) / 2 + start;
    int left = mergeSort(A, start, mid, temp);
    int right = mergeSort(A, mid + 1, end, temp);
    // 这种情况下，左边都比右边小，可以剪枝
    if (nums[mid] <= nums[mid + 1]) {
        return left + right;
    }
    return left + right + merge(A, start, end, temp);
}

// On, On
int merge(int[] A, int start, int end, int[] temp) {
    int mid = (end - start) / 2 + start;
    int left = start, right = mid + 1;
    int index = start;
    
    int ans = 0;
    while (left <= mid && right <= end) {
        if (A[left] <= A[right]) {
            temp[index++] = A[left++];
        } else {
            ans += mid - left + 1;
            temp[index++] = A[right++];
        }
    }
    
    // joint left numbers
    while (left <= mid) {
        temp[index++] = A[left++];
    }
    while (right <= end) {
        ans += mid - left + 1;
        temp[index++] = A[right++];
    }
    
    // copy to the origin array
    for (int i = start; i <= end; i++) {
        A[i] = temp[i];
    }
    
    return ans;
}