public class PGS_68645 {

    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    private int[][] triangle;
    private int[] result;
    private int value = 1;
    private int x = 0;
    private int y = 0;
    private int d = 0;

    public int[] solution(int n) {
        triangle = new int[n][n];

        while (true) {
            triangle[y][x] = value++;

            int newX = x + dx[d];
            int newY = y + dy[d];
            if (isOutOfIndex(n, newX, newY)) {
                d = (d + 1) % 3;
                newX = x + dx[d];
                newY = y + dy[d];
                if (isOutOfIndex(n, newX, newY)) {
                    break;
                }
            }
            x = newX;
            y = newY;
        }

        result = new int[value - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result[index++] = triangle[i][j];
            }
        }

        return result;
    }

    private boolean isOutOfIndex(int n, int newX, int newY) {
        return newX == n || newY == n || newX == -1 || newY == -1 || triangle[newY][newX] != 0;
    }
}
