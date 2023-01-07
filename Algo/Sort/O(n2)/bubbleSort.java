// 好处：在接近有序的数组上排序非常的快，发现有序后，可以直接结束
void bubbleSort(int[] a, int n) {
    boolean isSorted = false;
    for (int i = 0; i < n && !isSorted; ++i) {
        isSorted = true;
        for (int j = 0; j < n - 1 - i; ++j) {
            if (a[j] <= a[j + 1]) {
                continue;
            }
            isSorted = false;
            swap(a, j, j + 1);
        }
    }
}

void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}