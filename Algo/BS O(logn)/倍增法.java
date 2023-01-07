public int search(ArrayReader reader, int target) {
    int rangeTotal = 1;
    while (reader.get(rangeTotal - 1) < target) {
        rangeTotal = rangeTotal * 2;
    }
    
    int start = rangeTotal / 2, end = rangeTotal - 1;
    
}