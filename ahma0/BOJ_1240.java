import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int node[][];
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        node = new int[N + 1][N + 1];

        for(int  i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            node[a][b] = c;
            node[b][a] = c;

        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bfs(a, b);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[N + 1];

        visited[start] = true;
        queue.add(start);

        int ans[] = new int[N + 1];

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int i = 1; i <= N; i++) {
                if(node[now][i] > 0 && !visited[i]) {
                    ans[i] += ans[now] + node[now][i];

                    if(i == end) {
                        sb.append(ans[end]).append("\n");
                        return;
                    }

                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }


}