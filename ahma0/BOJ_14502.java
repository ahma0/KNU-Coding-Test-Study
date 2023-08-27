import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int moveX[] = {0, 0, 1, -1};
    static int moveY[] = {1, -1, 0, 0};
    static int maxSafe = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        sb.append(maxSafe).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 || map[i][j] == 2)
                    continue;

                map[i][j] = 1;
                dfs(cnt + 1);
                map[i][j] = 0;
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 2)
                    q.add(new Node(i, j));

        int[][] clone = new int[N][M];

        for(int i = 0; i < N; i++)
            clone[i] = map[i].clone();

        while(!q.isEmpty()) {
            Node now = q.poll();

            int x = now.x;
            int y = now.y;

            for(int i = 0; i < 4; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M)
                    continue;

                if(clone[newX][newY] == 0) {
                    q.offer(new Node(newX, newY));
                    clone[newX][newY] = 2;
                }
            }
        }

        checkSafe(clone);
    }

    static void checkSafe(int[][] cloneMap) {
        int cnt = 0;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(cloneMap[i][j] == 0)
                    cnt++;

        maxSafe = Math.max(cnt, maxSafe);
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

