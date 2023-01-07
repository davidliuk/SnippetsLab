// lc718
// O(M+N)log(min(M,N))
// 如果数组 A 和 B 有一个长度为 k 的公共子数组，那么它们一定有长度为 j <= k 的公共子数组。这样我们可以通过二分查找的方法找到最大的 k。
// 注意到序列内元素值小于 100100100 ，我们使用 Rabin-Karp 算法来对序列进行哈希。具体地，我们制定一个素数 base，那么序列 S 的哈希值为：
int mod = 1000000009;
int base = 113;

public int findLength(int[] A, int[] B) {
    int left = 1, right = Math.min(A.length, B.length) + 1;
    while (left < right) {
        int mid = left + (right - left) >> 1;
        if (check(A, B, mid)) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left - 1;
}

public boolean check(int[] A, int[] B, int len) {
    long hashA = 0;
    for (int i = 0; i < len; i++) {
        hashA = (hashA * base + A[i]) % mod;
    }
    Set<Long> bucketA = new HashSet<Long>();
    bucketA.add(hashA);
    long mult = qPow(base, len - 1);
    for (int i = len; i < A.length; i++) {
        hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
        bucketA.add(hashA);
    }
    
    long hashB = 0;
    for (int i = 0; i < len; i++) {
        hashB = (hashB * base + B[i]) % mod;
    }
    if (bucketA.contains(hashB)) {
        return true;
    }
    for (int i = len; i < B.length; i++) {
        hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
        if (bucketA.contains(hashB)) {
            return true;
        }
    }
    return false;
}

// 使用快速幂计算 x^n % mod 的值
public long qPow(long x, long n) {
    long ret = 1;
    while (n != 0) {
        if ((n & 1) != 0) {
            ret = ret * x % mod;
        }
        x = x * x % mod;
        n >>= 1;
    }
    return ret;
}