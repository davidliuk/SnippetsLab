int fastPower(int a, int b, int n) {
    long ans = 1, tmp = a;
    
    while (n != 0) {
        if (n % 2 == 1) {
            ans = (ans * tmp) % b;
        }
        tmp = (tmp * tmp) % b;
        n >>= 1;
    }
    
    return ans;
}