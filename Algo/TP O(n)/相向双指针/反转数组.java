// lc344
void reverseString(char[] s) {
    // 一左一右两个指针相向而行
    int left = 0, right = s.length() - 1;
    while (left < right) {
        // 交换 s[left] 和 s[right]
        swap(s, left, right);
        left++;
        right--;
    }
}

void swap(char[] nums, int left, int right) {
    char temp = s[left];
    s[left] = s[right];
    s[right] = temp;
}