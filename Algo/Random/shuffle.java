void shuffle(int[] nums) {
    Random rand = new Random();
    int n = nums.length;
    for (int i = 0 ; i < n; i++) {
        // 生成 [i, n - 1] 的随机数
        int r = i + rand.nextInt(n - i);
        swap(nums, i, r);
    }
}

// 原地交换数组中的两个元素
void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
