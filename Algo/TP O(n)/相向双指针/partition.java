public int partition(int[] nums, int start, int end) {
    int left = start, right = end;
    // 随机化，防止被卡（提速显著），这个和shuffle二选一
    swap(nums, start, new Random().nextInt(end - start + 1) + start);
    int pivot = nums[start];

    while (left < right) {
        while (left < right && nums[right] >= pivot) right--;
        while (left < right && nums[left] <= pivot) left++;
        swap(nums, left, right);
    }
    swap(nums, start, left);
    return left;
}

public int partition(int[] nums, int start, int end) {
    int left = start, right = end;
    // 随机化，防止被卡（提速显著）
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
