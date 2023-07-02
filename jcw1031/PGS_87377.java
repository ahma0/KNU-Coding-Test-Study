import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS_87377 {

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection =
                        intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimumPoint = getMinimumPoint(points);
        Point maximumPoint = getMaximumPoint(points);

        int width = (int) (maximumPoint.x - minimumPoint.x + 1);
        int height = (int) (maximumPoint.y - minimumPoint.y + 1);

        char[][] result = new char[height][width];
        for (char[] row : result) {
            Arrays.fill(row, '.');
        }

        for (Point point : points) {
            int x = (int) (point.x - minimumPoint.x);
            int y = (int) (maximumPoint.y - point.y);

            result[y][x] = '*';
        }

        String[] answer = new String[result.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(result[i]);
        }

        return answer;
    }

    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
        double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

        if (x % 1 != 0 || y % 1 != 0) {
            return null;
        }

        return new Point((long) x, (long) y);
    }

    private Point getMinimumPoint(List<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;

        for (Point point : points) {
            if (point.x < minX) {
                minX = point.x;
            }
            if (point.y < minY) {
                minY = point.y;
            }
        }

        return new Point(minX, minY);
    }

    private Point getMaximumPoint(List<Point> points) {
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point point : points) {
            if (point.x > maxX) {
                maxX = point.x;
            }
            if (point.y > maxY) {
                maxY = point.y;
            }
        }

        return new Point(maxX, maxY);
    }

    static class Point {

        private final long x;
        private final long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
