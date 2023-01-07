I. 边界设置：
- 初始化 left = right = 0，把索引左闭右开区间 [left, right) 称为一个「窗口」。
设计为左闭右开区间是最方便处理的。因为初始化 left = right = 0 时区间 [0, 0) 中没有元素。
如果两端都闭的区间，那么初始区间 [0, 0] 就包含了一个元素。这两种情况都会给边界处理带来不必要的麻烦。
- 可以选择让right=-1，然后先right++再将元素移入，这样是左闭右闭。不过没必要

II. 问题考虑
1. 什么时候应该移动 right 扩大窗口？窗口加入字符时，应该更新哪些数据？

2. 什么时候窗口应该暂停扩大，开始移动 left 缩小窗口？从窗口移出字符时，应该更新哪些数据？

3. 我们要的结果应该在扩大窗口时还是缩小窗口时进行更新？
- 要最长/大时，扩大
- 要最短/小时，缩小


int left = 0, right = 0;

while (right < s.length()) {
    // c 是将移入窗口的字符
    char c = s.charAt(right);
    // 增大窗口
    right++;
    // 进行窗口内数据的一系列更新
    ...
    // 如window.add(s.charAt(right));
    
    while (window needs shrink) {
        // 求最小值时，在这里更新答案
        ...
        // d 是将移出窗口的字符
        char d = s.charAt(left);
        // 缩小窗口
        left++;
        // 进行窗口内数据的一系列更新
        ...
        // 如window.remove(s.charAt(left));
    }
    // 求最大值时，在这里更新答案
    ...
}

/* 滑动窗口算法框架 */
void slidingWindow(String s) {
    Map<Character, Integer> window = new HashMap<>();
    
    int left = 0, right = 0;
    while (right < s.length()) {
        // c 是将移入窗口的字符
        // 增大窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        /*** debug 输出的位置 ***/
        // 注意在最终的解法代码中不要 print
        // 因为 IO 操作很耗时，可能导致超时
        System.out.printf("window: [%d, %d)\n", left, right);
        /********************/
        
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // 求最小值时，在这里更新答案
            ...
            // d 是将移出窗口的字符
            char d = s.charAt(left);
            // 缩小窗口
            left++;
            // 进行窗口内数据的一系列更新
            ...
        }
        // 求最大值时，在这里更新答案
        ...
    }
}

