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
