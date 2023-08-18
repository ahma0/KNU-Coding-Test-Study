import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static boolean[] visited = new boolean[100001];
    static int minTime = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        sb.append(minTime).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[N] = true;

        int move[] = new int[3];

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int n = now.x;

            if(n == K)
                minTime = Math.min(minTime, now.time);

            move[0] = n * 2;
            move[1] = n - 1;
            move[2] = n + 1;

            for(int i = 0; i < 3; i++) {

                if(move[i] < 0 || move[i] > 100000 ) continue;

                if(move[i] >= 0 && !visited[move[i]]) {
                    visited[move[i]] = true;
                    if(i == 0)
                        queue.add(new Node(move[i], now.time));
                    else
                        queue.add(new Node(move[i], now.time + 1));
                }
            }
        }
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

}