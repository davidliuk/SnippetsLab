// lc302
// 像素连续，
class Grid {
    static char BLACK = '1';
    static char WHITE = '0';
}

public int minArea(char[][] image, int x, int y) {
    if (image == null || image.length == 0) {
        return 0;
    }
    if (image[0] == null || image[0].length == 0) {
        return 0;
    }

    int n = image.length, m = image[0].length;
    int up = findFirst(image, 0, x, true);
    int down = findLast(image, x, n - 1, true);
    int left = findFirst(image, 0, y, false);
    int right = findLast(image, y, m - 1, false);

    return (down - up + 1) * (right - left + 1);
}

int findFirst(char[][] image, int start, int end, boolean row) {
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (row? checkRow(image, mid): checkCol(image, mid)) {
            end = mid;
        } else {
            start = mid;
        }
    }
    if (row? checkRow(image, start): checkCol(image, start)) {
        return start;
    }
    return end;
}

int findLast(char[][] image, int start, int end, boolean row) {
    while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (row? checkRow(image, mid): checkCol(image, mid)) {
            start = mid;
        } else {
            end = mid;
        }
    }
    if (row? checkRow(image, end): checkCol(image, end)) {
        return end;
    }
    return start;
}

boolean checkRow(char[][] image, int x) {
    for (int j = 0; j < image[0].length; j++) {
        if (image[x][j] == Grid.BLACK) {
            return true;
        }
    }
    return false;
}

boolean checkCol(char[][] image, int y) {
    for (int i = 0; i < image.length; i++) {
        if (image[i][y] == Grid.BLACK) {
            return true;
        }
    }
    return false;
}