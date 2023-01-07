int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
    int n = customers.length, sum = 0;
    for (int i = 0; i < n; i++) {
        if (i < minutes) {
            sum += customers[i];
        } else {
            sum += (1 - grumpy[i]) * customers[i];
        }
    }
    
    int result = sum;
    int left = 0, right = minutes;
    while (right < n) {
        if (grumpy[right] == 1) {
            sum += customers[right];
        }
        if (grumpy[left] == 1) {
            sum -= customers[left];
        }
        result = Math.max(result, sum);
        left++;
        right++;
    }

    return result;
}