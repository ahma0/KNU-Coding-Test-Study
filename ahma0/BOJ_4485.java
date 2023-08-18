import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] dist;
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        StringTokenizer st;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            arr = new int[N][N];
            dist = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = -1;
                }
            }

            search();

            sb.append("Problem ").append(cnt++).append(": ").append(dist[N - 1][N - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, arr[0][0]));
        dist[0][0] = arr[0][0];

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int nowX = now.x;
            int nowY = now.y;

            for(int i = 0; i < 4; i++) {
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N)
                    continue;

                if(dist[nextX][nextY] == -1 || dist[nextX][nextY] > arr[nextX][nextY] + now.cost) {
                    dist[nextX][nextY] = arr[nextX][nextY] + now.cost;
                    pq.add(new Node(nextX, nextY, dist[nextX][nextY]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}

