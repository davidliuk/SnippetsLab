// 买入一次
public int maxProfit(int[] prices) {
    int result = 0;
    int preMin = Integer.MAX_VALUE;
    for (int price: prices) {
        result = Math.max(result, price - preMin);
        preMin = Math.min(preMin, price);
    }
    return result;
}