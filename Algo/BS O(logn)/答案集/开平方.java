// 可以控制精度
double left = 0, right = target;
while (left + 0.001 < right) {
    double midlle = (right + left) / 2;
    if (midlle * midlle < target) {
        left = midlle;
    } else {
        right = midlle;
    }
}

// lc69 
public int mySqrt(int x) {
    int left = 0, right = x;

    while (left + 1 < right) {
        int mid = (right - left) / 2 + left;
        // 找到最左边的
        if ((long)mid * mid <= x) {
            left = mid;
        } else {
            right = mid;
        }
    }

    if ((long)right * right <= x) {
        return right;
    }
    return left;
}