import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char map[][];
    static boolean visited[][];
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        int max = 0;
        for(int i = 0; i < N; i++) {
            String temp = br.readLine();

            for(int j = 0; j < M; j++)
                map[i][j] = temp.charAt(j);
        }

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    max = Math.max(max, bfs(i, j));
                }

        sb.append(max).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, 0));
        visited[x][y] = true;

        int result = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nextX = node.x + moveX[i];
                int nextY = node.y + moveY[i];

                if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < M )
                    if(!visited[nextX][nextY] && map[nextX][nextY] == 'L') {
                        queue.add(new Node(nextX, nextY, node.cost + 1));
                        result = Math.max(result, node.cost + 1);
                        visited[nextX][nextY] = true;
                    }
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}