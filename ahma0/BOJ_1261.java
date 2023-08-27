import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];
        for(int i = 0; i < N; i++)
            Arrays.fill(dist[i], -1);

        String t;
        for(int i = 0; i < N; i++) {
            t = br.readLine();

            for(int j = 0; j < t.length(); j++)
                map[i][j] = t.charAt(j) - '0';
        }

        search();

        sb.append(dist[N - 1][M - 1]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void search() {
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.add(new Room(0, 0, 0));
        dist[0][0] = 0;

        while(!pq.isEmpty()) {
            Room now = pq.poll();

            for(int i = 0; i < 4; i++) {
                int x = now.x + moveX[i];
                int y = now.y + moveY[i];

                if(x < 0 || y < 0 || x >= N || y >= M)
                    continue;

                if(dist[x][y] == -1 || dist[x][y] > dist[now.x][now.y] + map[x][y]) {
                    pq.add(new Room(x, y, now.cnt + map[x][y]));
                    dist[x][y] = dist[now.x][now.y] + map[x][y];
                }
            }
        }

    }

    static class Room implements Comparable<Room> {
        int x;
        int y;
        int cnt;

        public Room(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Room o) {
            return this.cnt - o.cnt;
        }
    }

}

