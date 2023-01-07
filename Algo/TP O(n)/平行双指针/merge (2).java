// lc88
// On, On
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] temp = new int[m + n];
    int index = 0;
    int left = 0, right = 0;
    
    while (left < m && right < n) {
        if (nums1[left] < nums2[right]) {
            temp[index] = nums1[left];
            left++;
        } else {
            temp[index] = nums2[right];
            right++;
        }
        index++;
    }
    
    // joint left numbers
    while (left < m) {
        temp[index++] = nums1[left++];
    }
    while (right < n) {
        temp[index++] = nums2[right++];
    }
    
    for (int i = 0; i < m + n; i++) {
        nums1[i] = temp[i];
    }
}

// On, O1
// 倒着双指针
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int tail = m + n - 1;
    int p1 = m - 1, p2 = n - 1;
    
    while (p1 >= 0 && p2 >= 0) {
        if (nums1[p1] > nums2[p2]) {
            nums1[tail] = nums1[p1];
            p1--;
        } else {
            nums1[tail] = nums2[p2];
            p2--;
        }
        tail--;
    }
    
    // joint left numbers
    while (p1 >= 0) {
        nums1[tail--] = nums1[p1--];
    }
    while (p2 >= 0) {
        nums1[tail--] = nums2[p2--];
    }
}

// On, On
// [start, end]
// 因为两个数组共用一个数组，所以无法通过倒着双指针的方式节省空间
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
