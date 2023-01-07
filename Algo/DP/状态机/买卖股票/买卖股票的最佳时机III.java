// 分段买入两次
public int maxProfit(int[] prices) {
    int n = prices.length;
    int result = 0;
    for (int i = 0; i < n; i++) {
        int leftProfit = getProfit(prices, 0, i);
        int rightProfit = getProfit(prices, i, n);
        result = Math.max(
            result, leftProfit + rightProfit
        );
    }
    return result;
}

int getProfit(int[] prices, int left, int right) {
    int result = 0;
    int preMin = Integer.MAX_VALUE;
    for (int i = left; i < right;i++) {
        result = Math.max(result, prices[i] - preMin);
        preMin = Math.min(preMin, prices[i]);
    }
    return result;
}