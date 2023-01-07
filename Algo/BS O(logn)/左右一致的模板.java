// 更适合二分答案，且不需要考虑左右问题
while (low < high) {
    int mid = (high - low) / 2 + low;
    int count = countSubarrays(nums, mid);
    if (count < k) {
        low = mid + 1;
    } else {
        high = mid;
    }
}
return low;