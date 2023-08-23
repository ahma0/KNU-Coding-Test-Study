import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int board[];
    static int visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[101];
        for(int i = 1; i < 101; i++)
            board[i] = i;

        int t = N + M;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[x] = y;
        }

        visited = new int[101];

        bfs();

        sb.append(visited[100]).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int i = 1; i <= 6; i++) {
                int newNode = now + i;

                if(newNode > 100)
                    continue;

                if(visited[board[newNode]] == 0) {
                    q.add(board[newNode]);
                    visited[board[newNode]] = visited[now] + 1;
                }

                if(board[newNode] == 100)
                    return;
            }
        }
    }

}

