// 交换法，优点：可以解决一个不在数组里的元素可以在里面排第几的问题；和其他相向双指针统一
// 推荐
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
    return start;
}

// 挖坑法，课本写法
public int partition(int[] nums, int start, int end) {
    int pivot = nums[start];
    while (start < end) {
        while (start < end && nums[end] >= pivot) {
            end--;
        }
        nums[start] = nums[end];
        while (start < end && nums[start] <= pivot) {
            start++;
        }
        nums[end] = nums[start];
    }
    nums[start] = pivot;
    return start;
}

// lc写法
public int partition(int[] nums, int start, int end) {
    int pivot = nums[end];
    int i = start - 1;
    for (int j = start; j <= end - 1; j++) {
        if (nums[j] <= pivot) {
            i = i + 1;
            swap(nums, i, j);
        }
    } 
    swap(nums, i + 1, r);
    return i + 1;
}

public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}