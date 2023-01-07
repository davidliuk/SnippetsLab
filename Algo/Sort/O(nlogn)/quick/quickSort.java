// lc912
public int[] sortArray(int[] nums) {
    quickSort(nums, 0, nums.length - 1);

    return nums;
}

// [start, end]
void quickSort(int[] A, int start, int end) {
    // 递归出口
    if (start >= end) {
        return;
    }
    
    // 递归拆解
    int p = partition(A, start, end);
    quickSort(A, start, p - 1);
    quickSort(A, p + 1, end);
}

// On, O1
public int partition(int[] nums, int start, int end) {
    // 随机化，防止被卡（提速显著），这个和shuffle二选一
    swap(nums, start, new Random().nextInt(end - start + 1) + start);
    int pivot = nums[start];
    int left = start, right = end;

    while (left < right) {
        while (left < right && nums[right] >= pivot) right--;
        while (left < right && nums[left] <= pivot) left++;
        swap(nums, left, right);
    }
    swap(nums, start, left);
    return left;
}

public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

// jz写法
void quickSort(int[] A, int start, int end) {
    if (start == end) {
        return;
    }
    
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

    // 递归拆解
    quickSort(A, start, right);
    quickSort(A, left, end);
}


void quickSort(int[] A, int start, int end) {
    // 递归出口
    if (start == end) {
        return;
    }
    
    // 递归拆解
    int[] p = partition(A, start, end);
    quickSort(A, start, p[1]);
    quickSort(A, p[0], end);
}

// 九章写法
int[] partition(int[] A, int start, int end) {
    int left = start, right = end;
    // point 1,取pivot，经验下选择中点是最好的,Random也可以，但是Random也有耗费
    int pivot = A[(right - left) / 2 + left];

    // point 2,不严格小于，防止左右产生交集（这个数本身），最后右侧部分，产生无限递归
    // 如[1,2]快排，变成[1,1], [1, 2]，右边这个没有缩小范围
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

