// 抄书员只能抄连续的书，至少需要多长时间可以抄完
int copyBooks(int[] pages, int k) {
    if (pages == null || pages.length == 0) {
        return 0;
    }
    if (k == 0) {
        return -1;
    }
    
    int sum = 0;
    for (int page: pages) {
        sum += page;
    }
    
    int start = 0, end = sum - 1;
    while (start + 1 < end) {
        int mid = start + (end - left) / 2;
        if (getNumberOfCopiers(pages, mid) <= k) {
            end = mid;
        } else {
            start = mid;
        }
    }
    
    if (getNumberOfCopiers(pages, start) <= k) {
        return start;
    }
    
    return end;
}

int getNumberOfCopiers(int[] pages, int limit) {
    int copiers = 0;
    int lastCopied = limit;
    
    for (int page: pages) {
        if (page > limit) {
            return Integer.MAX_VALUE;
        }
        if (lastCopied + page >= limit) {
            copiers++;
            lastCopied = 0;
        }
        lastCopied += page;
    }
    
    return copiers;
}