// lc179
// On2，字符串的排序是插入排序等
public String largestNumber(int[] nums) {
    int n = nums.length;
    String[] ss = new String[n];
    for (int i = 0; i < n; i++) ss[i] = String.valueOf(nums[i]);
    Arrays.sort(ss, (a, b) -> {
        String sa = a + b, sb = b + a ;
        return sb.compareTo(sa);
    });
    
    StringBuilder sb = new StringBuilder();
    for (String s : ss) sb.append(s);
    int len = sb.length();
    int k = 0;
    while (k < len - 1 && sb.charAt(k) == '0') k++;
    return sb.substring(k);
}

// O(nlog⁡nlog⁡m)
public String largestNumber(int[] nums) {
    int n = nums.length;

    Arrays.sort(nums, (x, y) -> {
        long sx = 10, sy = 10;
        while (sx <= x) {
            sx *= 10;
        }
        while (sy <= y) {
            sy *= 10;
        }
        // 降序
        return (int) (-sy * x - y + sx * y + x);
    });

    if (nums[0] == 0) {
        return "0";
    }
    
    StringBuilder ret = new StringBuilder();
    for (int num : nums) {
        ret.append(num);
    }
    return ret.toString();
}
