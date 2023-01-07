// O(n)
void partition(int[] A, int pivot) {
    int left = 0, right = A.length - 1;
    
    // point 2,不严格小于，防止左右有交集产生无限递归
    while (left <= right) {
        // point 3,严格小于，否则如果是全部相等的序列right每次都不变
        while (left <= right && A[left] < pivot) {
            left++;
        }
        while (left <= right && A[right] > pivot) {
            right--;
        }
        if (left <= right) {
//             int temp = A[left];
//             A[left] = A[right];
//             A[right] = temp;
            swap(A, left, right);
            left++;
            right--;
        }
    }
}

void swap(int nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}