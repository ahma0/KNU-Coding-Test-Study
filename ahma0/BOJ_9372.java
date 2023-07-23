import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, cnt;
    static int plane[][];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            plane = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plane[a][b] = 1;
                plane[b][a] = 1;
            }

            cnt = 0;
            search();
            sb.append(cnt - 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void search() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            cnt++;

            for(int i = 1; i <= N; i++) {
                if(plane[now][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

}