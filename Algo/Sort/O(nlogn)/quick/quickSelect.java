// lc215
// jz076
public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
}

// 一下所有均为[start, end]闭区间
int quickSelect(int[] nums, int start, int end, int k) {
    if (start == end) {
        return nums[start];
    }

    int p = partition(nums, start, end);
    if (start + k < p) {
        return quickSelect(nums, start, p - 1, k);
    }
    if (start + k > p) {
        return quickSelect(nums, p + 1, end, k - (p + 1 - start));
    }

    return nums[p];
}

public int partition(int[] nums, int start, int end) {
    int left = start, right = end;
    // 随机化
    swap(nums, start, new Random().nextInt(end - start + 1) + start);
    int pivot = nums[start];

    while (left < right) {
        while (left < right && nums[right] >= pivot) {
            right--;
        }
        while (left < right && nums[left] <= pivot) {
            left++;
        }
        swap(nums, left, right);
    }
    swap(nums, start, left);
    return left;
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}


// jz写法
public int findKthLargest(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
        return  -1;
    }

    return quickSelect(nums, 0, nums.length - 1, k);
}

int quickSelect(int[] A, int start, int end, int k) {
    if (start == end) {
        return A[start];
    }

    int[] p = partition(A, start, end);
    int left = p[0], right = p[1];

    if (start + k - 1 <= right) {
        return quickSelect(A, start, right, k);
    }
    if (start + k - 1 >= left) {
        return quickSelect(A, left, end, k - (left - start));
    }

    return A[right + 1];
}

int[] partition(int[] A, int start, int end) {
    int left = start, right = end;
    // point 1,取pivot，经验下选择中点是最好的
    int pivot = A[(right - left) / 2 + left];

    // point 2,不严格小于，防止左右有交集产生无限递归
    while (left <= right) {
        // point 3,严格小于，否则如果是全部相等的序列每次都不变
        while (left <= right && A[left] < pivot) {
            left++;
        }
        while (left <= right && A[right] > pivot) {
            right--;
        }
        if (left <= right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }

    return new int[]{left, right};
}
