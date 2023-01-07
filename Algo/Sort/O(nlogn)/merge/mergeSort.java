// lc912
public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1, new int[nums.length]);

    return nums;
}

// [start, end]
void mergeSort(int[] A, int start, int end, int[] temp) {
    // 递归出口
    if (start >= end) {
        return;
    }
    
    // 递归拆解
    int mid = (end - start) / 2 + start;
    mergeSort(A, start, mid, temp);
    mergeSort(A, mid + 1, end, temp);
    // 这种情况下，左边都比右边小，可以剪枝
    if (nums[mid] <= nums[mid + 1]) {
        return;
    }
    merge(A, start, end, temp);
}

// On, On
void merge(int[] nums, int start, int end, int[] temp) {
    int mid = (end - start) / 2 + start;
    int index = start;
    int left = start, right = mid + 1;

    while (left <= mid && right <= end) {
        if (nums[left] < nums[right]) {
            temp[index] = nums[left];
            left++;
        } else {
            temp[index] = nums[right];
            right++;
        }
        index++;
    }

    // joint left numbers
    while (left <= mid) {
        temp[index++] = nums[left++];
    }
    while (right <= end) {
        temp[index++] = nums[right++];
    }

    for (int i = start; i <= end; i++) {
        nums[i] = temp[i];
    }
    // or System.arraycopy(temp, start, nums, start, end + 1 - start);
}


// 非递归写法
