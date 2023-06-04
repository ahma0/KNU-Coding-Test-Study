import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int I;
    static int arr[][];
    static boolean visited[][];
    static Point start, end;
    static int move_X[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int move_Y[] = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            I = Integer.parseInt(br.readLine());

            arr = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start_X = Integer.parseInt(st.nextToken());
            int start_Y = Integer.parseInt(st.nextToken());

            start = new Point(start_X, start_Y, 0);

            st = new StringTokenizer(br.readLine());

            int end_X = Integer.parseInt(st.nextToken());
            int end_Y = Integer.parseInt(st.nextToken());

            end = new Point(end_X, end_Y, 0);

            search(start);

        }

    }

    static void search(Point start) {
        Queue<Point> q = new LinkedList<>();

        q.add(start);
        visited[start.x][start.y] = true;

        while(!q.isEmpty()) {
            Point temp = q.poll();
            int now_X = temp.x;
            int now_Y = temp.y;
            int now_cnt = temp.cnt;

            if(now_X == end.x && now_Y == end.y) {
                System.out.println(now_cnt);
                return;
            }

            for(int i = 0; i < 8; i++) {
                int new_X = now_X + move_X[i];
                int new_Y = now_Y + move_Y[i];

                if(new_X < 0 || new_Y < 0 || new_X >= I || new_Y >= I)
                    continue;

                if(!visited[new_X][new_Y]) {
                    q.add(new Point(new_X, new_Y, now_cnt + 1));
                    visited[new_X][new_Y] = true;
                }
            }
        }
    }

    public static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
