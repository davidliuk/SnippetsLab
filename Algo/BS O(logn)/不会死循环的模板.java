// 可以通过控制start + x 来控制精度（用在二分法求平方根的时候）
// 处理左右问题时，有时比较难做（尤其是二分答案时）
public int findPosition(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }
    
    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        // 下面的==的情况需要根据题意稍作变化，看是要第一个还是最后一个还是随便一个，随便一个则直接return，第一个则令end变
        if (nums[mid] == target) {
            end = mid;
            // return mid
        }
        if (nums[mid] < target) {
            start = mid; //可以这样偷懒，因为这样也会退出
            // start = mid + 1;
        } else {
            end = mid; //可以这样偷懒，因为这样也会退出
            // end = mid - 1;
        }
    }
    
    if (nums[start] == target) {
        return start;
    }
    if (nums[end] == target) {
        return end;
    }
    return -1;
}