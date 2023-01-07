// 擅长处理
// [left, right)
void slidingWindow(int[] nums) {
    int count = 0, sum = 0;
    int left = 0, right = 0;
    while (right < nums.length) {
        // c 是将移入窗口的字符
        int c = nums[right++];
        // 进行窗口内数据的一系列更新
        // ...
        
        // 判断左侧窗口是否需要收缩
        while (sum > threshold) {
            // d 是将移出窗口的字符
            int d = nums[left];
            // 缩小窗口
            left++;
            // 进行窗口内数据的一系列更新
            // ...
        }
        // 更新答案
        // ...
    }
    return count;
}

// 擅长处理
// [left, right)
int count = 0, sum = 0;
int left = 0;
for (int right = 0; right < nums.length; right++) {
    // 入一个
    sum += nums[right];
    // 一直减，知道可以
    while (sum > threshold) {
        sum -= nums[left];
        left++;
    }
    count += right - left + 1;
}
return count;
