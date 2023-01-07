// lc 33
// 将一个严格递增的数组的前若干项元素搬到末尾
public int search(int[] numbers, int target) {
    if (numbers == null || numbers.length == 0) {
        return 0;
    }

    int start = 0, end = numbers.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < numbers[end]) {
            if (numbers[mid] < target && target <= numbers[end]) {
                start = mid;
            } else {
                end = mid;
            }
        } else {
            if (numbers[start] <= target && target < numbers[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
    }

    if (numbers[start] == target) {
        return start;
    }
    if (numbers[end] == target) {
        return end;
    }

    return -1;
}