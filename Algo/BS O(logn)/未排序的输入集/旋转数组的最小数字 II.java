// lc 154
// 剑指11
// 将一个不严格递增的数组的前若干项元素搬到末尾
public int minArray(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
        return 0;
    }

    int start = 0, end = numbers.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (numbers[mid] == numbers[end]) {
            end -= 1;
        } else if (numbers[mid] < numbers[end]) {
            end = mid;
        } else {
            start = mid;
        }
    }

    if (numbers[start] < numbers[end]) {
        return numbers[start];
    }
    return numbers[end];
}