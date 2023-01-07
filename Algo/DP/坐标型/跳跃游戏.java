// nums代表每一个位置可以往后跳的步数
// 判断是否可以调到最右侧
public boolean canJump(int[] nums) {
    if (nums == null || nums.length == 0) {
        return false;
    }

    boolean[] dp = new boolean[nums.length];

    dp[0] = true;

    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && nums[j] + j >= i) {
                dp[i] = true;
                break;
            }
        }
    }

    return dp[nums.length - 1];
}