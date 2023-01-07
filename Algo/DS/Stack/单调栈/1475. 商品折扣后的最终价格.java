// lc1475
public int[] finalPrices(int[] prices) {
    int[] result = Arrays.copyOf(prices, prices.length);
    Stack<Integer> stack = new Stack();
    for (int i = 0; i < prices.length; i++) {
        while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
            result[stack.peek()] = prices[stack.peek()] - prices[i];
            stack.pop();
        }
        stack.push(i);
    }

    return result;
}