// 空间复杂度On
void merge(int[] A, int start, int end, int[] temp) {
    // double pointer
    int mid = (end - start) / 2 + start;
    int left = start, right = mid + 1;
    int index = start;
    
    while (left <= mid && right <= end) {
        if (A[left] < A[rigjt]) {
            temp[index] = A[left];
            left++
        } else {
            temp[index] = A[right];
            right++
        }
        index++
    }
    
    // joint left numbers
    while (left <= mid) {
        temp[index++] = A[left++];
    }
    while (right <= end) {
        temp[index++] = A[right++];
    }
    
    // copy to the origin array，On,On
    for (int i = start; i <= end; i++) {
        A[i] = temp[i];
    }
    
}
