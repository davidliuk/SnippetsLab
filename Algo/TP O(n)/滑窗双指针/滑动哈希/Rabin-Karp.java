// Rabin-Karp 指纹字符串查找算法
int rabinKarp(String txt, String pat) {
    // 数字位数
    int L = pat.length();
    // 进制（只考虑 ASCII 编码）
    int R = 256;
    // 取一个比较大的素数作为求模的除数
    long Q1 = 1000000009;
    long Q2 = 1000000007;
    // R^(L - 1) 的结果
    long RL1 = 1, RL2 = 1;
    for (int i = 1; i <= L - 1; i++) {
        // 计算过程中不断求模，避免溢出
        RL1 = (RL1 * R) % Q1;
        RL2 = (RL2 * R) % Q2;
    }
    // 计算模式串的哈希值，时间 O(L)，双哈希
    long patHash1 = 0, patHash2 = 0;
    for (int i = 0; i < pat.length(); i++) {
        patHash1 = (R * patHash1 + pat.charAt(i)) % Q1;
        patHash2 = (R * patHash2 + pat.charAt(i)) % Q2;
    }
    
    // 滑动窗口中子字符串的哈希值
    long windowHash1 = 0, windowHash2 = 0;
    
    // 滑动窗口代码框架，时间 O(N)
    int left = 0, right = 0;
    while (right < txt.length()) {
        // 扩大窗口，移入字符
        windowHash1 = ((R * windowHash1) % Q1 + txt.charAt(right)) % Q1;
        windowHash2 = ((R * windowHash2) % Q2 + txt.charAt(right)) % Q2;
        right++;

        // 当子串的长度达到要求
        if (right - left == L) {
            // 根据哈希值判断是否匹配模式串
            if (windowHash1 == patHash1 && windowHash2 == patHash2) {
                // 当前窗口中的子串哈希值等于模式串的哈希值
                // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                // if (pat.equals(txt.substring(left, right))) {
                return left;
                // }
            }
            // 缩小窗口，移出字符
            windowHash1 = (windowHash1 - (txt.charAt(left) * RL1) % Q1 + Q1) % Q1;
            windowHash2 = (windowHash2 - (txt.charAt(left) * RL2) % Q2 + Q2) % Q2;
            // X % Q == (X + Q) % Q 是一个模运算法则
            // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
            // 所以额外再加一个 Q，保证 windowHash 不会是负数
            left++;
        }
    }
    // 没有找到模式串
    return -1;
}
